package cc.ligu.common.shiro.filter;

import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.utils.GsonUtil;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by zjy on 2018/5/22.
 */
@Component
public class PermissionAuthFilter extends PermissionsAuthorizationFilter implements AjaxFilter {

    private String rst = GsonUtil.toJson(ResultEntity.newResultEntity(ResultEntity.ERR_CODE, "登录状态异常,请刷新页面", null));

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        return (!AjaxUtil.handleAjaxAppRequest(request, response, this)) && super.onAccessDenied(request, response);
    }

    @Override
    public String getRst(ServletRequest request, ServletResponse response) {
        return this.rst;
    }
}
