package cc.ligu.common.interceptor;

import cc.ligu.common.exception.PermissionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zjy on 2018/5/22.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","*");
        // 获得请求路径的uri
        String uri = request.getRequestURI();
        if (StringUtils.isEmpty(uri)) {
            throw new PermissionException();
        }
        Subject loginUser = SecurityUtils.getSubject();
        if (loginUser.isAuthenticated())
            return true;
        response.sendRedirect("login");
        return true;
    }

}
