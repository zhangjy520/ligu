package cc.ligu.common.interceptor;

import cc.ligu.mvc.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zjy on 2018/5/22.
 */
public class AppLoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    CacheService cacheService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin","*");
        //Object userView = new CaceSe.getUserInfoFromSession(request, request.getParameter("clientId"));
        Object userView = cacheService.getCacheByKey(request.getParameter("clientId"));
        if (userView != null)
            return true;
        response.sendRedirect(request.getContextPath() + "/api/permissionDeny");
        return false;
    }

}
