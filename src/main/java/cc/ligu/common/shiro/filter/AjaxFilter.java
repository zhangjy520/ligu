package cc.ligu.common.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by zjy on 2018/5/22.
 */
public interface AjaxFilter {

    String getRst(ServletRequest request, ServletResponse response);
}
