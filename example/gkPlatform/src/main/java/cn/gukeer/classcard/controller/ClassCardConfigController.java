package cn.gukeer.classcard.controller;

import cn.gukeer.classcard.modelView.ClassCardConfigScreenOffView;
import cn.gukeer.classcard.modelView.ClassCardConfigView;
import cn.gukeer.classcard.modelView.ClassCardView;
import cn.gukeer.classcard.persistence.entity.*;
import cn.gukeer.classcard.service.*;
import cn.gukeer.classcard.util.ClassCardCommand;
import cn.gukeer.common.controller.BasicController;
import cn.gukeer.common.entity.ResultEntity;
import cn.gukeer.common.utils.DateUtils;
import cn.gukeer.common.utils.PrimaryKey;
import cn.gukeer.common.utils.PropertiesUtil;
import cn.gukeer.platform.common.UserRoleType;
import cn.gukeer.platform.persistence.entity.User;
import cn.gukeer.platform.service.impl.CacheServiceImpl;
import cn.gukeer.sync.netty.classCardAttendance.ClassCardCommandServer;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wulianedu.netty.server.ServerInstance;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alpha on 18-1-16.
 */
@Controller
@RequestMapping(value = "/classcard")
public class ClassCardConfigController extends BasicController {

    @Autowired
    ClassCardService classCardService;

    @Autowired
    ClassCardConfigService classCardConfigService;

    @Autowired
    ClassCardConfigScreenOffRefService cccsorService;

    @Autowired
    ClassCardConfigRefService classCardConfigRefService;

    @Autowired
    CacheManager cacheManager;

    Properties properties = PropertiesUtil.getProperties("api.properties");
    Integer netty_classcard_command_port = Integer.parseInt((String) properties.get("netty_classcard_command_port"));

    /**
     * 开关机配置
     */
    @RequestMapping(value = "/config/index")
    public String configIndex(HttpServletRequest request, Model model) {
        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        PageInfo<ClassCardConfigView> pageInfo = new PageInfo<>();
        if (subject.isAuthenticated()) {
            if (subject.hasRole(UserRoleType.ROLE_CLASSCARDADMIN) || subject.hasRole(UserRoleType.ROLE_SCHOOLADMIN)) {
                pageInfo = classCardConfigService.findAllConfigBySchoolId(user.getSchoolId(), pageNum, pageSize);
            } else {
                List<ClassCard> classCards = classCardService.findClassCardByTeacherId(user.getRefId());
                List<String> classCardIds=new ArrayList<>();
                for(ClassCard classCard:classCards){
                    classCardIds.add(classCard.getId());
                }
                pageInfo = classCardConfigService.findAllConfigByClassCardIds(classCardIds,pageNum,pageSize);
            }
        }
        List<ClassCardConfigView> resultList = classCardConfigService.transforConfig(pageInfo.getList());
        pageInfo.setList(resultList);
        model.addAttribute("pageInfo", pageInfo);

        return "classCard/config/index";
    }

    @RequestMapping(value = "/config/edit")
    public String configEdit(HttpServletRequest request, Model model) {
        String classCardConfigId = getParamVal(request, "id");
        String option = getParamVal(request, "option");

        if (!"".equals(classCardConfigId) && classCardConfigId != null) {

            Subject subject = SecurityUtils.getSubject();
            User user = (User) subject.getPrincipal();

            if (subject.isAuthenticated()) {
                if (subject.hasRole(UserRoleType.ROLE_CLASSCARDADMIN) || subject.hasRole(UserRoleType.ROLE_SCHOOLADMIN)|| subject.hasRole(UserRoleType.ROLE_HEADTEACHER)) {
                    ClassCardConfigView classCardConfigView = classCardConfigService.findOneClassCardConfigById(classCardConfigId);
                    classCardConfigView = classCardConfigService.transforConfigOne(classCardConfigView);
                    List<ClassCardConfigScreenOffView> cccsoViewList = cccsorService.findListClassCardScreenOffByCCCId(classCardConfigId);
                    String checkedIds = classCardConfigRefService.findClassCardConfigCheckedIds(classCardConfigId, user.getSchoolId());
                    model.addAttribute("classCardConfigScreen", cccsoViewList);
                    model.addAttribute("classCardConfig", classCardConfigView);
                    model.addAttribute("checkedIds", checkedIds);
                    model.addAttribute("option", option);
                }
            }
        }
        return "classCard/config/edit";
    }


    @Transactional
    @ResponseBody
    @RequestMapping(value = "/config/save", method = RequestMethod.POST)
    public ResultEntity saveClassCardConfig(HttpServletRequest request, Model model) {
        String configId = getParamVal(request, "configId");
        String name = getParamVal(request, "name");
//        String startDate = getParamVal(request, "startDate");
//        String endDate = getParamVal(request, "endDate");
//        String screenOffWeek = getParamVal(request, "screenOffWeek");
        String week = getParamVal(request, "week");
        String startTime = getParamVal(request, "startTime");
        String endTime = getParamVal(request, "endTime");
        String screenOffWeek = week;

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (subject.isAuthenticated()) {
            if (!subject.hasRole(UserRoleType.ROLE_SCHOOLADMIN)&&!subject.hasRole(UserRoleType.ROLE_CLASSCARDADMIN)&&!subject.hasRole(UserRoleType.ROLE_HEADTEACHER)) {
                return ResultEntity.newErrEntity("当前用户权限不足");
            }
        }
        if ("".equals(name) || "".equals(week)) {
            return ResultEntity.newErrEntity("配置参数不能为空");
        }

        String screenOffTimeList = getParamVal(request, "screenOffTimeList");
        String classCard = getParamVal(request, "classCardList");

        if (!StringUtils.isNotEmpty(screenOffTimeList)) {
            return ResultEntity.newErrEntity("未配置熄亮屏时间或配置错误");
        }
        if (!StringUtils.isNotEmpty(classCard)) {
            return ResultEntity.newErrEntity("未配置终端设备或配置错误");
        }

        //保存息屏时间数组，key存开始，value存结束
        HashMap<String, String> screenOffTimeMap = new HashMap<>();
        String[] timeArray = screenOffTimeList.split(";");
        for (int i = 0; i < timeArray.length; i++) {
            String[] temp = timeArray[i].split(",", -2);
            screenOffTimeMap.put(temp[0], temp[1]);
        }

        //保存执行此配置的班牌
        List<String> classCardList = new ArrayList<>();
        Collections.addAll(classCardList, classCard.split(","));

        if (classCardList == null || screenOffTimeMap == null) {
            return ResultEntity.newErrEntity("时间段/终端设备,配置错误");
        }

        //开关机时间格式进行转换，保存时间戳
        Long startTimeLong = null;
        Long endTimeLong = null;
        try {
            startTimeLong = DateUtils.stringToTimestamp(startTime, "HH:mm");
            endTimeLong = DateUtils.stringToTimestamp(endTime, "HH:mm");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("时间格式错误");
        }

        //进行重复验证，防止一个班牌的多个配置时间段冲突
        String checkoutResult = checkoutPowerTime(week, startTimeLong, endTimeLong, classCardList, configId);
        if ("error".equals(checkoutResult)) {
            return ResultEntity.newErrEntity("配置数据错误");
        } else if (!"".equals(checkoutResult)) {
            return ResultEntity.newErrEntity(checkoutResult);
        }

        ClassCardConfig classCardConfig = new ClassCardConfig();
        classCardConfig.setName(name);
        classCardConfig.setWeek(week);
        classCardConfig.setStartTime(startTimeLong);
        classCardConfig.setEndTime(endTimeLong);

        ServerInstance instance = ClassCardCommandServer.getInstance_command();
        CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");

        int count = 0;
        if (configId == null || "".equals(configId)) {
            //新增配置
            configId = PrimaryKey.get();
            classCardConfig.setId(configId);
            classCardConfig.setCreateBy(user.getId());
            classCardConfig.setCreateDate(System.currentTimeMillis());
            //insert
            try {
                count += classCardConfigService.insertClassCardConfig(classCardConfig);
                if(!(screenOffTimeMap.containsKey("")&&StringUtils.isBlank(screenOffTimeMap.get("")))){
                    count += cccsorService.insertClassCardConfigScreenRef(configId, screenOffWeek, screenOffTimeMap);
                }
                count += classCardConfigRefService.insertClassCardConfigRef(configId, user.getSchoolId(), classCardList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            classCardConfig.setId(configId);
            classCardConfig.setUpdateBy(user.getId());
            classCardConfig.setUpdateDate(System.currentTimeMillis());
            //udpate
            try {
                count += classCardConfigService.updateClassCardConfig(classCardConfig);
                count += cccsorService.updateClassCardConfigScreenRef(configId, screenOffWeek, screenOffTimeMap);
                count += classCardConfigRefService.updateClassCardConfigRef(configId, user.getSchoolId(), classCardList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ResultEntity resultEntity = ResultEntity.newErrEntity("保存失败");
        //判断条件需要修改boolean，不严谨
        if (count >= 0) {
            resultEntity = ResultEntity.newResultEntity("操作成功");

            if (null != classCardList && classCardList.size() > 0) {
                for (String classcardId : classCardList) {
                    ClassCard card = classCardService.findClassCardByClassCardId(classcardId);
                    String macFormate = card.getMacId().replace(":", "_").toUpperCase() + "_" + netty_classcard_command_port;

                    Map<String, Object> configMap = new HashMap<>();

                    configMap.put("command", ClassCardCommand.CONFIG_UPDATE);
                    configMap.put("mac", macFormate);

                    Map<String, Object> dataMap = new HashMap<>();
                    dataMap.put("configId", configId);
                    dataMap.put("weekSet", week);

                    //息屏亮屏数据
                    List<Map<String, Object>> screenList = new ArrayList<>();
                    for (Map.Entry<String, String> entry : screenOffTimeMap.entrySet()) {
                        try {
                            Map<String, Object> screenMap = new HashMap<>();
                            screenMap.put("screenOffTime", DateUtils.stringToTimestamp(entry.getKey(), "HH:mm"));
                            screenMap.put("screenOnTime", DateUtils.stringToTimestamp(entry.getValue(), "HH:mm"));
                            screenList.add(screenMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    dataMap.put("screenConfigList", screenList);

                    //开关机时间对数据
                    Map<String, Long> powerConfig = new HashMap<>();
                    powerConfig.put("powerOnTime", startTimeLong);
                    powerConfig.put("powerOffTime", endTimeLong);
                    dataMap.put("powerConfig", powerConfig);

                    configMap.put("data", dataMap);

                    //一个设备可能有多个配置未推送，用list在缓冲中保存。
                    List<Map<String, Object>> configMapList = new ArrayList<>();
                    configMapList.add(configMap);

                    //管道连通,可推送数据
                    if (instance.channelStatus(macFormate)) {
                        System.out.println("==================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
                        instance.sendMessage(macFormate, new Gson().toJson(configMap));
                        System.out.println("==============Data sent successfully=============" + new Gson().toJson(configMap));
                        //推送失败放到缓存
                    } else {
                        System.out.println("==================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when push switchgear config  mac:"+macFormate);
                        configMapList = (List<Map<String, Object>>) cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.CONFIG_UPDATE);
                        int index = isConfigExist(configMapList, configId);
                        if (index != -1) {
                            configMapList.remove(index);
                            configMapList.add(index, configMap);
                        }
                        System.out.println(macFormate + "_" + ClassCardCommand.CONFIG_UPDATE);
                        cacheService.addCache(macFormate + "_" + ClassCardCommand.CONFIG_UPDATE, configMapList);
                    }
                }
            }

            //上次选中这次未选中的设备，推送取消该配置的命令
            String oldClassCard = getParamVal(request, "oldClassCardList");
            if (!classCard.equals(oldClassCard) && !oldClassCard.isEmpty()) {
                //取消配置的设备推送取消该配置
                List<String> oldClassCardList = new ArrayList<>();
                Collections.addAll(oldClassCardList, oldClassCard.split(","));
                if (!compare(oldClassCardList, classCardList) && !oldClassCardList.isEmpty()) {
                    //找到需要取消的id，一个去掉重复的数组
                    //循环调用用id,找到mac,,参数configId,mac
                    oldClassCardList = delDuplicates(oldClassCardList, classCardList);
                    if (oldClassCardList != null) {
                        for (String classCardId : oldClassCardList) {
                            String mac = classCardService.findClassCardByClassCardId(classCardId).getMacId();
                            delCanalOfConfig(mac, configId);
                        }
                    }
                }
            }
        }
        return resultEntity;
    }

    /**
     * 在a中去掉两list的并集
     *
     * @param a
     * @param b
     * @return
     */
    private List<String> delDuplicates(List<String> a, List<String> b) {
        //a.removeAll(b);
        for (String s : b) {
            a.remove(s);
        }
        return a;
    }

    /**
     * 比较两个list是否相同
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    private <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.size() != b.size())
            return false;
        Collections.sort(a);
        Collections.sort(b);
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i)))
                return false;
        }
        return true;
    }

    //验证发布的配置是否和已经发布的有时间段的重复
    private String checkoutPowerTime(String week, Long startTime, Long endTime, List<String> classcardList, String configId) {
        if ("".equals(week) || "".equals(startTime) || "".equals(endTime) || classcardList.isEmpty()) {
            return "error";
        }
        for (String classcardId : classcardList) {
            List<ClassCardConfigView> classCardConfigViews = classCardConfigService.findConfigListView(classCardConfigRefService.findConfigListByClasscardId(classcardId));
            for (ClassCardConfigView classCardConfigView : classCardConfigViews) {
                if (classCardConfigView == null || configId.equals(classCardConfigView.getId())) {
                    continue;
                }
                if (isRepeat(week, classCardConfigView.getWeek())) {
                    if (classCardConfigView.getStartTime() > startTime && classCardConfigView.getStartTime() < endTime
                            || classCardConfigView.getEndTime() > startTime && classCardConfigView.getEndTime() < endTime
                            || classCardConfigView.getStartTime() < startTime && classCardConfigView.getEndTime() > endTime) {
                        String resultMessage = "错误：与\"" + classCardService.findClassCardByClassCardId(classcardId).getEquipmentName() + "\"";
                        resultMessage += "的\"" + classCardConfigView.getName() + "\"时间段冲突";
                        return resultMessage;
                    }
                }
            }
        }
        return "";
    }

    //判断两个week是否有重复的值
    private boolean isRepeat(String array1, String array2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list1, array1.split(","));
        Collections.addAll(list2, array2.split(","));
        return !Collections.disjoint(list1, list2);
    }

    @Transactional
    @ResponseBody
    @RequestMapping(value = "/config/multidelete")
    public ResultEntity deleteConfig(HttpServletRequest request, Model model) {
        String configIds = getParamVal(request, "configId");
        ResultEntity resultEntity = ResultEntity.newErrEntity("删除失败");

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (subject.isAuthenticated()) {
            if (!subject.hasRole(UserRoleType.ROLE_SCHOOLADMIN)&&!subject.hasRole(UserRoleType.ROLE_CLASSCARDADMIN)&&!subject.hasRole(UserRoleType.ROLE_HEADTEACHER)) {
                return ResultEntity.newErrEntity("当前用户权限不足");
            }
        }

        if (!"".equals(configIds) && configIds != null) {
            int configCount = 0;
            String[] configIdArr = configIds.split(",");
            if (configIdArr != null) {
                try {
                    //遍历推送命令给删除配置的班牌
                    for (String tempConfigId : configIdArr) {
                        List<ClassCardConfigRef> classCardRefs = classCardConfigRefService.findRefByConfigId(tempConfigId);
                        for (ClassCardConfigRef classCardTemp : classCardRefs) {
                            if (StringUtils.isNotBlank(classCardTemp.getClassCardId())) {
                                ClassCard card = classCardService.findClassCardByClassCardId(classCardTemp.getClassCardId());

                                //推送删除到mac
                                delCanalOfConfig(card.getMacId(), tempConfigId);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //推送完成后进行库数据删除
                configCount += classCardConfigRefService.deleteClassCardConfigRef(configIdArr, user.getSchoolId());
                configCount += cccsorService.deleteClassCardConfigScreenRef(configIdArr);
                configCount += classCardConfigService.deleteClassCardConfig(configIdArr);
                //判断条件不严谨,改为boolean与进行判断
                if (configCount > 0) {
                    resultEntity = ResultEntity.newResultEntity("删除成功");
                }
            }
        }
        return resultEntity;
    }

    /**
     * 将当前要删除的配置进行推送
     *
     * @param mac
     * @param configId
     */
    private void delCanalOfConfig(String mac, String configId) {
        ServerInstance instance = ClassCardCommandServer.getInstance_command();
        CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");
        String macFormate = mac.replace(":", "_").toUpperCase() + "_" + netty_classcard_command_port;

        //推送的数据
        Map<String, Object> delConfigMap = new HashMap<>();
        delConfigMap.put("command", ClassCardCommand.CONFIG_REMOVE);
        delConfigMap.put("mac", macFormate);
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("configId", configId);
        delConfigMap.put("data", dataMap);

        //管道连通,可推送数据
        if (instance.channelStatus(macFormate)) {
            System.out.println("==================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
            instance.sendMessage(macFormate, new Gson().toJson(delConfigMap));
            System.out.println("===============Data sent successfully=============" + new Gson().toJson(delConfigMap));
        } else {
            //推送失败放到缓存
            System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when delete switchgear config  mac:"+macFormate);
            List<Map<String, Object>> configMapList = new ArrayList<>();
            configMapList = (List<Map<String, Object>>) cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.CONFIG_UPDATE);
            //为每个设备维护一个缓冲map，删除先在缓冲中删除，如果没有继续缓冲。
            int index = isConfigExist(configMapList, configId);
            if (index != -1) {
                configMapList.remove(index);
                configMapList.add(index, delConfigMap);
            }
            cacheService.addCache(macFormate + "_" + ClassCardCommand.CONFIG_UPDATE, configMapList);
        }
    }

    /**
     * 判断当前准备推送的配置是否在缓冲中存在
     *
     * @return
     */
    private int isConfigExist(List<Map<String, Object>> configMapList, String configId) {
        if (configMapList == null) {
            return -1;
        }
        for (int i = 0; i < configMapList.size(); i++) {
            Map<String, Object> temp = configMapList.get(i);
            if (ClassCardCommand.CONFIG_UPDATE.equals(temp.get("command"))) {
                Map<String, Object> data = (Map<String, Object>) temp.get("data");
                if (configId.equals(data.get("configId"))) {
                    return i;
                }
            }
        }
        return -1;
    }

    //与添加班牌选择设备的那个接口是相同的，调用同一个service
    @RequestMapping(value = "/config/chooseclasscardConfig")
    public String chooseConfigClassCard(HttpServletRequest request, Model model) {
        String checkedIds = getParamVal(request, "checkedIds");
        String disabled = getParamVal(request, "disabled");
        //查询所有绑定班级的班牌
        Map<String, Map<String, List<ClassCardView>>> resultMap = classCardService.selectEquipmentForNotify();
        JsonObject returnData = new JsonParser().parse(new Gson().toJson(resultMap)).getAsJsonObject();
        model.addAttribute("returnData", returnData);
        model.addAttribute("checkedIds", checkedIds);
        model.addAttribute("disabled", disabled);
        return "classCard/config/chooseclasscardConfig";
    }

    @RequestMapping(value = "/config/oneConfigInfo")
    public String oneConfigInfoPage(HttpServletRequest request, Model model) {
        String classcardId = getParamVal(request, "id");
        List<ClassCardConfigView> classCardConfigViews = classCardConfigService.findConfigListView(classCardConfigRefService.findConfigListByClasscardId(classcardId));
        model.addAttribute("classcardConfigViews", classCardConfigViews);
        model.addAttribute("classcardId", classcardId);
        return "classCard/editConfig";
    }

    @RequestMapping(value = "/config/findConfigClasscard")
    public String findConfigClasscard(HttpServletRequest request, Model model) {
        String configId = request.getParameter("configId");
        List<String> classcardIds = classCardConfigRefService.findConfigClasscardByConfigId(configId);
        List<ClassCard> publishClassCards = new ArrayList<>();
        for (String classcardId : classcardIds) {
            publishClassCards.add(classCardService.findClassCardByClassCardId(classcardId));
        }
        model.addAttribute("publishClasscards", publishClassCards);
        return "classCard/config/configClasscard";
    }

    @RequestMapping(value = "/config/deleteOne")
    public ResultEntity deleteOne(HttpServletRequest request) {
        ResultEntity resultEntity = ResultEntity.newErrEntity("删除单个设备的单条配置失败");
        String classCardId = request.getParameter("classcardId");
        String configId = request.getParameter("configId");

        if (!classCardId.isEmpty() && !configId.isEmpty()) {
            try {
                //遍历推送命令给删除配置的班牌
                ClassCard card = classCardService.findClassCardByClassCardId(classCardId);
                delCanalOfConfig(card.getMacId(), configId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //推送删除命令配置命令后删除库中数据
            classCardConfigRefService.deleteClassCardConfigRefOne(classCardId, configId);
            //如果该配置的最后一个班牌，同时删除该配置
            List<ClassCardConfigRef> classCardRefs = classCardConfigRefService.findRefByConfigId(configId);
            if (classCardRefs == null || classCardRefs.isEmpty()) {
                String[] configIdArr = {configId};
                cccsorService.deleteClassCardConfigScreenRef(configIdArr);
                classCardConfigService.deleteClassCardConfig(configIdArr);
            }
            resultEntity = ResultEntity.newResultEntity();
        }
        return resultEntity;
    }
}
