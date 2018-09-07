package org.wuzhe.tysfhelper.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 师院助手的管理系统登陆入口
 * 
 * @author wuzhe
 *
 */
@Controller
public class Login {

	@RequestMapping(value="login.do",method = RequestMethod.GET)
	public String initLogin() {
		return "login";
	}

	@RequestMapping(value="login.do",method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> params) {
		String type = params.get("type");
		/**
		 * 判断用户身份
		 */
		if ("teacher".equals(type)) {
			return "forward:teacher/login.do";
		} else if ("classadmin".equals(type)) {
			return "forward:classadminLogin.do";
		}else{
			return "forward:adminLogin.do";
		}
		

	}
	@RequestMapping("quitLogin.do")
	public String login(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.removeAttribute("id");
		return "login";
		
	}
}
