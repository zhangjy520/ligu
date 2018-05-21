package com.activiti.test.action;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.activiti.test.entity.BsUser;
import com.activiti.test.service.IBsUserService;
import com.activiti.test.utils.MD5;
import com.activiti.test.utils.SessionTool;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class LoginController{
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	
	@Autowired
	private IBsUserService bsUserService;
	
	@RequestMapping("/login")
	public String loginView(HttpServletRequest request){
		Object user = SessionTool.getUserInfoFromSession(request);
		if(StringUtils.isEmpty(user)){
			return "login";
		}
		return "redirect:../menu/index";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest request,Model model,String name,String password){
		log.info("=======用户登陆======");
		BsUser user = bsUserService.getUserByNameAndPassword(name, MD5.toMD5(password));
		if(user != null){
			model.addAttribute("success", true);
			SessionTool.setUserInfo2Session(request, user);
			Object url = SessionTool.getUrlInfoFromSession(request);
//			if(StringUtils.isEmpty(url)){
				return "redirect:../menu/index";
//			}else{
//				return "redirect:"+url.toString();
//			}
		}
		model.addAttribute("fail", true);
		return "login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		SessionTool.clearSessionByKey(request, "user");
		SessionTool.clearSessionByKey(request,"url");
		return "redirect:login";
	}
}
