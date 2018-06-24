package cc.ligu.common.interceptor;

import cc.ligu.common.exception.PermissionException;
import cc.ligu.common.utils.SessionTool;
import cc.ligu.common.utils.SpringContextHolder;
import cc.ligu.mvc.service.CacheService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
        //Object userView = new CaceSe.getUserInfoFromSession(request, request.getParameter("clientId"));
        Object userView = cacheService.getCacheByKey(request.getParameter("clientId"));
        if (userView != null)
            return true;
        response.sendRedirect(request.getContextPath() + "/api/permissionDeny");
        return false;
    }

}
