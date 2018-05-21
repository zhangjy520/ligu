package cc.ligu.common.tld;

import org.springframework.util.StringUtils;

/**
 * Created by conn on 2016/8/12.
 */
public class GukeerStringUtil {

    public static Boolean isEmpty(String str) {

        return StringUtils.isEmpty(str);

    }

    public static Boolean notEmpty(String str) {

        return !isEmpty(str);

    }
}
