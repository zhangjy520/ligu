package cc.ligu.common.tld;

import org.springframework.util.StringUtils;

/**
 * Created by zjy on 2018/5/21.
 */
public class GukeerStringUtil {

    public static Boolean isEmpty(String str) {

        return StringUtils.isEmpty(str);

    }

    public static Boolean notEmpty(String str) {

        return !isEmpty(str);

    }
}
