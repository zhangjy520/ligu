package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.exception.ErrcodeException;
import cc.ligu.common.security.AESencryptor;
import cc.ligu.mvc.common.UserRoleType;
import cc.ligu.mvc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController extends BasicController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public String toLogin(HttpServletRequest request, HttpServletResponse response) {
        return "login/login";
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public ResultEntity login(HttpServletRequest request, HttpServletResponse response, Model model) {

        String username = getParamVal(request, "username");
        String password = getParamVal(request, "password");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new ErrcodeException("用户名或密码不能为空");
        }

        UsernamePasswordToken token = new UsernamePasswordToken(username.toLowerCase(), AESencryptor.encryptCBCPKCS5Padding(password));
        Subject loginUser = SecurityUtils.getSubject();
        String errmsg = null;

        try {
            loginUser.login(token);
        } catch (UnknownAccountException uae) {
            errmsg = "账户不存在";
        } catch (IncorrectCredentialsException ice) {
            errmsg = "用户名或者密码错误";
        } catch (LockedAccountException lae) {
            errmsg = "账户已锁定,暂时不能登录";
        } catch (ExcessiveAttemptsException eae) {
            errmsg = "错误次数过多,暂时不能登录";
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            ae.printStackTrace();
        }

        if (!loginUser.isAuthenticated()) {
            token.clear();
            if (StringUtils.isEmpty(errmsg)) {
                errmsg = "验证出错,请联系管理员";
            }
            throw new ErrcodeException(errmsg);
        }

        WebUtils.getSavedRequest(request);
        String url = "/";

        if (loginUser.isAuthenticated()) {
            if (loginUser.hasRole(UserRoleType.ROLE_ROOT)) {
                url = "device/index";
            }
        }
        return ResultEntity.newResultEntity(url);
    }
}
