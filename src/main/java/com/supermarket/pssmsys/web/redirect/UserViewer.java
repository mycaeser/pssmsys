package com.supermarket.pssmsys.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserViewer {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String showUserInfoList() {// 显示首页
		return "user/list";
	}
}
