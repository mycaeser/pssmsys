package com.supermarket.pssmsys.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginViewer {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String showPssmSysIndex() {// 显示首页
		return "login";
	}
}
