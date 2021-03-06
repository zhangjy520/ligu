package cc.ligu.common.shiro;

import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.*;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjy on 2018/5/22.
 */
public class ShiroAuthRealm extends AuthorizingRealm {

    private UserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        UserView user = (UserView) super.getAvailablePrincipal(principalCollection);

        SimpleAuthorizationInfo simpleAuthorInfo = null;
        if (null != "") {

            simpleAuthorInfo = new SimpleAuthorizationInfo();

            List<String> permissions = new ArrayList<String>();

            UserView userView = userService.selectUserViewByPrimary(user.getRefId());
            if (null != userView) {
                permissions.add(userView.getRolePermission());
                simpleAuthorInfo.addRole(userView.getRoleName());
            }
            //添加菜单的permisssion字段，jc:manage:*,jc:manage:ab
            /*List<RoleView> roleViews = userService.selectRoleViewByUserId(user.getId());
            for (RoleView roleView : roleViews) {
                String role = roleView.getRoleIdentify();
                if (!StringUtils.isEmpty(role)) {
                    simpleAuthorInfo.addRole(role);

                    List<MenuView> menuViews = userService.selectMenusByRoleId(roleView.getId());

                    for (MenuView menuView : menuViews) {
                        String permission = menuView.getPermission();
                        if (!StringUtils.isEmpty(permission)) {
                            permissions.add(permission);
                        }
                    }
                }
            }*/
            /*simpleAuthorInfo.addRole("root");
            simpleAuthorInfo.addRole("checker");
            simpleAuthorInfo.addRole("item_er");
            simpleAuthorInfo.addRole("worker_er");
            simpleAuthorInfo.addRole("worker");*/

            simpleAuthorInfo.addStringPermissions(permissions);
        } else {
            throw new AuthorizationException();
        }

        return simpleAuthorInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String pwd = String.valueOf(usernamePasswordToken.getPassword());
        if (StringUtils.isEmpty(username)) {
            return null;
        }

        UserView user = userService.selectUserViewByUsernameAndPassword(username, pwd);

        if (user != null) {
            return new SimpleAuthenticationInfo(user,
                    user.getPassword(), getName());
        }

        return null;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
