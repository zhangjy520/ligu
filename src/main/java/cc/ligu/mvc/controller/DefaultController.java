package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class DefaultController extends BasicController{

    @RequestMapping(value = "/err")
    public String err() {
        return "error";
    }

	@RequestMapping(value = "/", method = {RequestMethod.GET})
    public String root(HttpServletRequest request) {
        boolean isLogin = LoginUtil.isLoginUser(request);
        logger.info("login status=========:{}", isLogin);
        if (isLogin) {
            return "index";
        } else {
            return "login/login";
        }
    }
}
