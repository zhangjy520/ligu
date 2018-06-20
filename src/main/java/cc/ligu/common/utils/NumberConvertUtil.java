package cc.ligu.common.utils;

/**
 * 接受默认值，处理异常
 *
 * Created by zjy on 2018/5/21.
 */
public class NumberConvertUtil {

    public static int convertS2I(String val) {
        return convertS2I(val, 0);
    }

    public static int convertS2I(String val, int def) {
        int rst = def;
        try {
            rst = Integer.parseInt(val);
        } catch (Exception e) {

        }
        return rst;
    }

    public static int getVal(Integer val) {
        if (null == val) return 0;
        return val;
    }

    public static float getVal(Float val) {
        if (null == val) return 0f;
        return val;
    }

    public static double getVal(Double val) {
        if (null == val) return 0;
        return val;
    }

    public static long getVal(Long val) {
        if (null == val) return 0l;
        return val;
    }

    public static Long convertS2L(String val, long def) {
        long rst = def;
        try {
            rst = Long.parseLong(val);
        } catch (Exception e) {

        }
        return rst;

    }

    public static Long convertS2L(String val) {
        return convertS2L(val, 0);
    }
}
