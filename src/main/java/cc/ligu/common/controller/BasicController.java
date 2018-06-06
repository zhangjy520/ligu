package cc.ligu.common.controller;

import cc.ligu.common.exception.ErrcodeException;
import cc.ligu.common.utils.LoggerWrapper;
import cc.ligu.common.utils.NumberConvertUtil;
import cc.ligu.mvc.common.ProjectConfig;
import cc.ligu.mvc.persistence.entity.UserView;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zjy on 2018/5/22.
 */
@Controller
public abstract class BasicController extends LoggerWrapper {

    protected int getPageNum(HttpServletRequest request) {

        int _pageNum = 0;
        if (null == request) return _pageNum;

        String pageNum = getParamVal(request, "pageNum");
        if (StringUtils.isEmpty(pageNum)) return _pageNum;

        _pageNum = NumberConvertUtil.convertS2I(pageNum);

        return _pageNum;
    }

    protected int getPageSize(HttpServletRequest request) {

        int _pageSize = ProjectConfig.DEFAULT_PAGE_SIZE;
        if (null == request) return _pageSize;

        String pageSize = getParamVal(request, "numPerPage");
        if (StringUtils.isEmpty(pageSize)) return _pageSize;

        _pageSize = NumberConvertUtil.convertS2I(pageSize);
        if (_pageSize == 0) {
            _pageSize = ProjectConfig.DEFAULT_PAGE_SIZE;
        }

        return _pageSize;
    }

    protected String getParamVal(HttpServletRequest request, String key) {
        return getParamVal(request, key, "");
    }

    protected String getParamVal(HttpServletRequest request, String key, String defaultVal) {

        String val = defaultVal;
        if (null == request) return val;

        String value = request.getParameter(key);
        if (StringUtils.isEmpty(value)) return val;

        return value;
    }

    protected String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_VIA");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    protected UserView getLoginUser() {
        Subject subject = SecurityUtils.getSubject();
        UserView user = (UserView) subject.getPrincipal();
        if (null == user || StringUtils.isEmpty(user.getId())) {
            throw new ErrcodeException("登录超时，请重新登录");
        }
        return user;
    }

    protected Subject getSubject() {
        Subject subject = SecurityUtils.getSubject();
        if (null == subject) {
            throw new ErrcodeException("登录超时，请重新登录");
        }
        return subject;
    }
}
