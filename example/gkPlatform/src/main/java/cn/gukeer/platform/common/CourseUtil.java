package cn.gukeer.platform.common;

import cn.gukeer.classcard.persistence.entity.ClassCard;
import cn.gukeer.classcard.service.ClassCardService;
import cn.gukeer.common.tld.GukeerStringUtil;
import cn.gukeer.common.utils.NumberConvertUtil;
import cn.gukeer.common.utils.StringUtils;
import cn.gukeer.platform.modelView.TeachTableView;
import cn.gukeer.platform.persistence.entity.DailyHour;
import cn.gukeer.platform.persistence.entity.GradeClass;
import cn.gukeer.platform.persistence.entity.TeachCycle;
import cn.gukeer.platform.service.ClassService;
import cn.gukeer.platform.service.TeachTaskService;
import cn.gukeer.platform.service.impl.CacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alpha on 17-11-24.
 */
@Service
public class CourseUtil {
    @Autowired
    CacheManager cacheManager;

    @Autowired
    ClassCardService classCardServiceTmp;

    @Autowired
    ClassService classServiceTmp;

    @Autowired
    TeachTaskService teachTaskServiceTmp;

    private static ClassCardService classCardService;

    private static ClassService classService;

    private static TeachTaskService teachTaskService;

    @PostConstruct
    public void init() {
        classCardService = this.classCardServiceTmp;
        classService = this.classServiceTmp;
        teachTaskService = this.teachTaskServiceTmp;
    }

    /**
     * 当天课程
     *
     * @return
     */
    public static List<TeachTableView> todaySchedule(String mac) {

        if (StringUtils.isNotEmpty(mac) && mac.contains("_")) {
            mac = mac.replace("_", ":");
        }
        ClassCard classCard = classCardService.selectClassCardByMacId(mac);
        if (classCard == null) {
            return null;
        }

        if (StringUtils.isEmpty(classCard.getClassId())) {
            return null;
        }
        String classId = classCard.getClassId();
        GradeClass gradeClass = classService.selectClassById(classId);

        TeachCycle teachCycle = new TeachCycle();
        if (gradeClass != null) {
            teachCycle = getLatestTeachCycle(gradeClass.getSchoolId());
        }
        Long termBeginTime = 0L;
        String cycleId = "";
        if (teachCycle.getId() != null) {
            termBeginTime = teachCycle.getTermBeginTime();
            cycleId = teachCycle.getId();
        }

        Long currenttime = System.currentTimeMillis();

        Integer currentWeek = 1;
        if (currenttime > termBeginTime) {
            //获取今天是星期几
            Integer weekofoneday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
            if (weekofoneday == 0) {
                weekofoneday = 7;
            }

            //获取开学日期是星期几
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(termBeginTime);
            int startweekofoneday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (startweekofoneday == 0) {
                startweekofoneday = 7;
            }

            Long zhengshu = (currenttime - termBeginTime) / 1000 / 60 / 60 / 24 - weekofoneday + 1;
            System.out.println(zhengshu);
            if (zhengshu % 7 > 0) {
                currentWeek = (int) (zhengshu / 7 + 2);
            } else {
                currentWeek = (int) (zhengshu / 7 + 2);
            }
        }
        DailyHour dailyHour = teachTaskService.fingDailyHourByCycleIdAndClassId(cycleId, classId);
        Integer totalHour = 0;
        List<Integer> integers = new ArrayList<>();
        if (dailyHour != null) {
            totalHour = dailyHour.getSwks() + dailyHour.getXwks();
            for (int i = 0; i < totalHour; i++) {
                integers.add(i);
            }
        }
        Integer weekofoneday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
        if (weekofoneday == 0) {
            weekofoneday = 7;
        }


        List<TeachTableView> currentTeachTable = teachTaskService.findCurrentTeachTable(currentWeek, classId, cycleId, weekofoneday);
        return currentTeachTable;
    }


    /**
     * 当前时间是第几节课
     *
     * @param mac
     * @return
     */
    public static int currentNode(String mac) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        String[] arr = format.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1970-1-1 ").append(arr[1]);
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(stringBuilder.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long curTime = date.getTime();
        int node = -1;
        Long tenMinute = 60 * 10 * 1000L;//上课前十分钟就算考勤
        List<TeachTableView> teachTableViews = todaySchedule(mac);
        for (TeachTableView ttv : teachTableViews) {
            if (ttv.getStartTime() - tenMinute <= curTime && ttv.getEndTime() >= curTime) {
                node = NumberConvertUtil.convertS2I(ttv.getNode());
                break;
            }
        }
        return node;
    }

    public static TeachCycle getLatestTeachCycle(String schoolId) {
        List<TeachCycle> cycleList = teachTaskService.getCyclePageInfo(0, 0, schoolId).getList();
        TeachCycle cycleLatest = new TeachCycle();
        if (cycleList != null && cycleList.size() > 0) {
            cycleLatest = cycleList.get(0);
        }
        return cycleLatest;
    }

    public static Long getCurrentWeek(Long termBeginTime, Long currentWeek) {
        Long currenttime = System.currentTimeMillis();
        if (currenttime > termBeginTime) {
            //获取今天是星期几
            Integer weekofoneday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
            if (weekofoneday == 0) {
                weekofoneday = 7;
            }

            //获取开学日期是星期几
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(termBeginTime);
            int startweekofoneday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (startweekofoneday == 0) {
                startweekofoneday = 7;
            }

            Long zhengshu = (currenttime - termBeginTime) / 1000 / 60 / 60 / 24 - weekofoneday + 1;
            System.out.println(zhengshu);
            if (zhengshu % 7 > 0) {
                currentWeek = (zhengshu / 7 + 2);
            } else {
                currentWeek = (zhengshu / 7 + 2);
            }
        }

        return currentWeek;
    }

   /* //保存所有课表
    public void saveTeachTableToCache() {

        //查询所有课表，保存到缓存，key为 currentWeek+classId+cycleId+weekofoneday
        List<TeachTableView> allTables = teachTaskService.findCurrentTeachTable(-1, null, null, -1);

        Map<String, List<TeachTableView>> teachTableCache = new HashMap();
        for (TeachTableView v : allTables) {
            String key = v.getWeekend() + v.getClassId() + v.getCycleId() + v.getWeekDay();

            if (teachTableCache.containsKey(key)) {

                //如果课表map里已经存在这个key,则取出list放入
                teachTableCache.get(key).add(v);

            } else {

                //如果课表map里无此key，新建集合放入课表
                List<TeachTableView> list = new ArrayList<>();
                list.add(v);
                teachTableCache.put(key, list);
            }
        }

        CacheServiceImpl cacheInstance = new CacheServiceImpl(cacheManager, "action-cache");
        //将课表存入到缓存
        cacheInstance.addCache("teach_table", teachTableCache);

    }

    //根据mac获取今天课表，缓存中有从缓存中取，缓存中没有查数据库,并且查完放入缓存
    public List<TeachTableView> getTodayCache(int currentWeek, String classId, String cycleId, int weekDay) {
        String key = currentWeek + classId + cycleId + weekDay;

        CacheServiceImpl cacheInstance = new CacheServiceImpl(cacheManager, "action-cache");

        Object teachTableCache = cacheInstance.getCacheByKey("teach_table");

        Map<String, List<TeachTableView>> cache = new HashMap<>();
        if (!GukeerStringUtil.isNullOrEmpty(teachTableCache)) {
            //如果缓存有课表信息，则取出来；
            cache = (Map<String, List<TeachTableView>>) teachTableCache;
            return cache.get(key);
        } else {
            Map<String, List<TeachTableView>> queryDb = new HashMap<>();
            List<TeachTableView> fromDb = teachTaskService.findCurrentTeachTable(currentWeek, classId, cycleId, weekDay);
            queryDb.put(key, fromDb);
            cacheInstance.addCache("teach_table", queryDb);
            return fromDb;
        }
    }*/
}
