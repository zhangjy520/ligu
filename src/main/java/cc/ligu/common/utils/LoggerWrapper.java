package cc.ligu.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zjy on 2018/5/21.
 */
public abstract class LoggerWrapper {
    protected Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
}
