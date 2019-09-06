package com.supermarket.pssmsys.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/goods")
public class GoodsViewer {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String showGoodsList() {// 显示首页
		return "goods/list";
	}
}
