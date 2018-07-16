package cc.ligu.common.utils;

import net.sf.json.JSONObject;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zjy on 2016/9/9.
 */
public class DicUtil {

    //题目类别：1单选题 2多选题 3其他
    public static List<KVEntity> questionTypeList = new ArrayList<KVEntity>();
    //题目难度：1简单 2一般 3困难
    public static List<KVEntity> questionLevelList = new ArrayList<KVEntity>();

    //文档类别：0全部1安全生产视频课程2安全生产培训文档3安全生产安全守则4施工工艺视频课程5施工工艺培训文档6施工工艺工艺示例
    public static List<KVEntity> documentTypeList = new ArrayList<KVEntity>();

    //性别：1男 2女
    public static List<KVEntity> genderList = new ArrayList<>();

    //人员类别：1超级管理员 2人员审核管理员(主任) 3项目管理员(移动公司项目经理) 4施工管理员(施工方项目经理) 5施工工人
    public static List<KVEntity> personTypeList = new ArrayList<>();

    //人员类别对应的权限
    public static List<KVEntity> roleList = new ArrayList<>();

    //人员类别对应的权限
    public static List<KVEntity> rolePermissionList = new ArrayList<>();


    //人员状态 审核状态[0未审核 1已审核]
    public static List<KVEntity> personStatusList = new ArrayList<>();

    //黑名单状态[0正常 1黑名单人员]
    public static List<KVEntity> personBlackList = new ArrayList<>();


    public static Map<String, Object> map = new HashMap<String, Object>();

    static {
        KVEntity entry = new KVEntity("1", "单选题");
        questionTypeList.add(entry);
        entry = new KVEntity("2", "多选题");
        questionTypeList.add(entry);
        entry = new KVEntity("3", "其他");
        questionTypeList.add(entry);

        entry = new KVEntity("1", "简单");
        questionLevelList.add(entry);
        entry = new KVEntity("2", "一般");
        questionLevelList.add(entry);
        entry = new KVEntity("3", "困难");
        questionLevelList.add(entry);

        //0全部 1 安全生产视频课程 2 安全生产培训文档 3 安全生产安全守则 4 施工工艺视频课程 5 施工工艺培训文档 6 施工工艺工艺示例
        entry = new KVEntity("1", "安全生产视频课程");
        documentTypeList.add(entry);
        entry = new KVEntity("2", "安全生产培训文档");
        documentTypeList.add(entry);
        entry = new KVEntity("3", "安全生产安全守则");
        documentTypeList.add(entry);
        entry = new KVEntity("4", "施工工艺视频课程");
        documentTypeList.add(entry);
        entry = new KVEntity("5", "施工工艺培训文档");
        documentTypeList.add(entry);
        entry = new KVEntity("6", "施工工艺工艺示例");
        documentTypeList.add(entry);

        entry = new KVEntity("1", "男");
        genderList.add(entry);
        entry = new KVEntity("2", "女");
        genderList.add(entry);

        //1 超级管理员 2 人员审核管理员(主任) 3 项目管理员(移动公司项目经理) 4 施工管理员(施工方项目经理) 5 施工工人
        entry = new KVEntity("1", "超级管理员");
        personTypeList.add(entry);
        entry = new KVEntity("2", "人员审核管理员");
        personTypeList.add(entry);
        entry = new KVEntity("3", "项目管理员");
        personTypeList.add(entry);
        entry = new KVEntity("4", "施工管理员");
        personTypeList.add(entry);
        entry = new KVEntity("5", "施工工人");
        personTypeList.add(entry);

        entry = new KVEntity("0", "未审核");
        personStatusList.add(entry);
        entry = new KVEntity("1", "已审核");
        personStatusList.add(entry);

        entry = new KVEntity("1", "root");
        roleList.add(entry);
        entry = new KVEntity("2", "checker");
        roleList.add(entry);
        entry = new KVEntity("3", "item_er");
        roleList.add(entry);
        entry = new KVEntity("4", "worker_er");
        roleList.add(entry);
        entry = new KVEntity("5", "worker");
        roleList.add(entry);

        entry = new KVEntity("1", "per:all:*");
        rolePermissionList.add(entry);
        entry = new KVEntity("2", "per:check:*");
        rolePermissionList.add(entry);
        entry = new KVEntity("3", "per:item:*");
        rolePermissionList.add(entry);
        entry = new KVEntity("4", "per:worker:*");
        rolePermissionList.add(entry);
        entry = new KVEntity("5", "per:common:*");
        rolePermissionList.add(entry);

        entry = new KVEntity("0", "正常");
        personBlackList.add(entry);
        entry = new KVEntity("1", "黑名单待审");
        personBlackList.add(entry);
        entry = new KVEntity("2", "已列入黑名单");
        personBlackList.add(entry);

        map.put("questionType", questionTypeList);
        map.put("questionLevel", questionLevelList);
        map.put("documentType", documentTypeList);
        map.put("gender", genderList);
        map.put("personType", personTypeList);
        map.put("personStatus", personStatusList);
        map.put("roles", roleList);
        map.put("permissions", rolePermissionList);
        map.put("personBlack", personBlackList);
    }


    public static String getValueByKeyAndFlag(int key, String which) {
        String val = "";
        List<KVEntity> kvEntityList = (List<KVEntity>) map.get(which);
        for (KVEntity entity: kvEntityList) {
            if (entity.getKey().equals(String.valueOf(key))) {
                val = entity.getValue();
                break;
            }
        }
        return val;
    }

    public static Integer getKeyByValueAndFlag(String value, String which) {
        int val = 0;
        List<KVEntity> kvEntityList = (List<KVEntity>) map.get(which);
        for (KVEntity entity: kvEntityList) {
            if (entity.getValue().equals(value)) {
                val = Integer.parseInt(entity.getKey());
                break;
            }
        }
        return val;
    }

    public static List<String> splitWithOutNull(String param) {
        String[] res = param.split(",");
        List<String> out = new ArrayList<>();
        for (String v: res) {
            if (!StringUtils.isEmpty(v))
                out.add(v);
        }
        return out;
    }

    public static List searchParam(String paramList) {
        if (StringUtils.isEmpty(paramList))
            return null;
        String str = paramList.replace("[", "").replace("]", "");
        String[] resS = str.split(",");
        List resL = new ArrayList();
        resL = Arrays.asList(resS);
        return resL;
    }

    public static String getValueFromJson(String json, String key) {
        try {
            JSONObject data = JSONObject.fromObject(json);
            return data.get(key).toString();
        } catch (Exception e) {
            return "";
        }
    }


    public static long getBeginTime(int year, int month) {
        Date d= null;
        try {
            d = new SimpleDateFormat("yyyyMM").parse(year+""+month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }

    public static long getEndTime(int year, int month){
        Date d= null;
        try {
            d = new SimpleDateFormat("yyyyMM").parse(year+""+month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        //设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND,59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间戳
        return c.getTimeInMillis();

    }


    public static void main(String[] args) {
        System.out.println(getBeginTime(2018,7));
        System.out.println(getEndTime(2018,7));

        String s = "1data,2data,5data,6data".replaceAll("[5-9]data","");
        System.out.println("sss");
        System.out.println("32".compareTo("22"));
        System.out.println("32".compareTo("32"));
        System.out.println("32".compareTo("33"));
        System.out.println("77".compareTo("100"));
        System.out.println("72".compareTo("7"));
    }
}
