package cc.ligu.common.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by conn on 16-10-12.
 */
public class ConfigData {

    /**
     * 手环扫描时间间隔
     */
    public static final int RING_SCAN_INTERVAL = 3;

    /**
     *  超过一定时间，为离班状态
     */
    public static final double GOT_OUT_MINUTES = 3;

    /**
     * 当前对象实例
     */
    private static ConfigData instance = new ConfigData();

    /**
     * 显示/隐藏
     */
    public static final String SHOW = "1";
    public static final String HIDE = "0";

    /**
     * 是/否
     */
    public static final Integer YES = 1;
    public static final Integer NO = 0;

    /**
     * 状态[0:正常, 1:异常，2丢失]
     */
    public static final Integer AVAILABLE = 0;
    public static final Integer UNAVAILABLE = 1;
    public static final Integer LOSE = 2;
    /**
     * 获取当前对象实例
     */
    public static ConfigData getInstance() {
        return instance;
    }


    // =================================
    private static Map<String, List<cc.ligu.common.config.KVEntity>> map = new HashMap<String, List<cc.ligu.common.config.KVEntity>>();

    // 手环状态 【0未激活, 1激活正常, 2:异常，3丢失，4脱腕】
    public static final String RING_STATUS_KEY = "ring_status_key";
    public static List<cc.ligu.common.config.KVEntity> ringStatus = new ArrayList<cc.ligu.common.config.KVEntity>();

    static {

        cc.ligu.common.config.KVEntity entry = new cc.ligu.common.config.KVEntity("0", "未激活");
        ringStatus.add(entry);
        entry = new cc.ligu.common.config.KVEntity("1", "正常");
        ringStatus.add(entry);
        entry = new cc.ligu.common.config.KVEntity("2", "异常");
        ringStatus.add(entry);
        entry = new cc.ligu.common.config.KVEntity("3", "丢失");
        ringStatus.add(entry);
        entry = new cc.ligu.common.config.KVEntity("4", "脱腕");
        ringStatus.add(entry);

        map.put(RING_STATUS_KEY, ringStatus);
    }

    /**
     * 根据类型属性、key获取 key表示的意义
     * @param which
     * @param key
     * @return
     */
    public static String getValueByKeyAndFlag(String which, int key) {
        String val = "";
        List<cc.ligu.common.config.KVEntity> kvEntityList= (List<cc.ligu.common.config.KVEntity>) map.get(which);
        if (null != kvEntityList) {
            for (cc.ligu.common.config.KVEntity entity : kvEntityList) {
                if (entity.getKey().equals(String.valueOf(key))) {
                    val = entity.getValue();
                    break;
                }
            }
        }
        return val;
    }

    /**
     * 根据类型属性、key的含义获取 key
     * @param which
     * @param value
     * @return
     */
    public static Integer getKeyByValueAndFlag (String which, String value) {
        int val =0;
        List<cc.ligu.common.config.KVEntity> kvEntityList= (List<cc.ligu.common.config.KVEntity>) map.get(which);
        if (null != kvEntityList) {
            for (cc.ligu.common.config.KVEntity entity : kvEntityList) {
                if (entity.getValue().equals(value)) {
                    val = Integer.parseInt(entity.getKey());
                    break;
                }
            }
        }
        return val;
    }
}
