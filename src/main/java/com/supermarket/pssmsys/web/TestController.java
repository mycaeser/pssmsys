package com.supermarket.pssmsys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String index() {// ��ʾȨ�޹���
		return "test/index";
	}
}
