package cc.ligu.common.utils;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by zjy on 2016/9/9.
 */
public class DicUtil {

    // 题目类别
    public static List<KVEntity> questionTypeList = new ArrayList<KVEntity>();
    //题目难度
    public static List<KVEntity> questionLevelList = new ArrayList<KVEntity>();

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

        map.put("questionType", questionTypeList);
        map.put("questionLevel", questionLevelList);
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
        System.out.println(getKeyByValueAndFlag("一年级","nj"));
        System.out.println(getKeyByValueAndFlag("二年级","nj"));
        System.out.println(getKeyByValueAndFlag("三年级","nj"));
        System.out.println(splitWithOutNull("asdasd"));
    }
}
