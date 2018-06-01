package cc.ligu.common.utils;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by zjy on 2016/9/9.
 */
public class DicUtil {

    //题目类别：1单选题 2多选题 3其他
    public static List<KVEntity> questionTypeList = new ArrayList<KVEntity>();
    //题目难度：1简单 2一般 3困难
    public static List<KVEntity> questionLevelList = new ArrayList<KVEntity>();

    //文档类别：1培训文档 2安全原则 3视频课程
    public static List<KVEntity> documentTypeList = new ArrayList<KVEntity>();

    //性别：1男 2女
    public static List<KVEntity> genderList = new ArrayList<>();
    //人员类别：1管理员 2施工人员
    public static List<KVEntity> personTypeList = new ArrayList<>();

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

        entry = new KVEntity("1", "培训文档");
        documentTypeList.add(entry);
        entry = new KVEntity("2", "安全原则");
        documentTypeList.add(entry);
        entry = new KVEntity("3", "视频课程");
        documentTypeList.add(entry);

        entry = new KVEntity("1", "男");
        genderList.add(entry);
        entry = new KVEntity("2", "女");
        genderList.add(entry);

        entry = new KVEntity("1", "管理员");
        personTypeList.add(entry);
        entry = new KVEntity("2", "施工人员");
        personTypeList.add(entry);


        map.put("questionType", questionTypeList);
        map.put("questionLevel", questionLevelList);
        map.put("documentType", documentTypeList);
        map.put("gender", genderList);
        map.put("personType", personTypeList);
    }


    public static String getValueByKeyAndFlag(int key, String which) {
        String val = "";
        List<KVEntity> kvEntityList = (List<KVEntity>) map.get(which);
        for (KVEntity entity : kvEntityList) {
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
        for (KVEntity entity : kvEntityList) {
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
        for (String v : res) {
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


    public static void main(String[] args) {
    }
}
