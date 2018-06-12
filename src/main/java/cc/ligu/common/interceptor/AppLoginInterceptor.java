package cc.ligu.common.interceptor;

import cc.ligu.common.exception.PermissionException;
import cc.ligu.common.utils.SessionTool;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zjy on 2018/5/22.
 */
public class AppLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        Object userView = SessionTool.getUserInfoFromSession(request, request.getParameter("clientId"));
        if (userView != null)
            return true;
        response.sendRedirect("api/permissionDeny");
        return true;
    }

}
