package cc.ligu.common.interceptor;

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
        // 获得请求路径的uri
      /*  String uri = request.getRequestURI();
        if (StringUtils.isEmpty(uri)) {
            throw new PermissionException();
        }
        Subject loginUser = SecurityUtils.getSubject();
        if (loginUser.isAuthenticated()) return true;
        response.sendRedirect("index");*/
        return true;
    }

}
