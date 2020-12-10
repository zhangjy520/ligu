package cc.ligu.common.shiro.filter;

import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zjy on 2018/5/22.
 */
public class AjaxUtil {

    public static boolean handleAjaxAppRequest(ServletRequest request, ServletResponse response, AjaxFilter filter) throws IOException {
        if (filter != null && isAjaxRequest(request)) {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(filter.getRst(request, response));
            writer.flush();
            return true;
        }
        return false;
    }

    public static boolean isAjaxRequest(ServletRequest request) {
        HttpServletRequest req = WebUtils.toHttp(request);
        String xmlHttpRequest = req.getHeader("X-Requested-With");
        if (xmlHttpRequest != null) {
            if (xmlHttpRequest.equalsIgnoreCase("XMLHttpRequest")) {
                return true;
            }
        }
        return false;
    }
}
