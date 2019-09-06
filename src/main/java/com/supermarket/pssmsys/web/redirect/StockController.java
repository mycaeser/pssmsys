package com.supermarket.pssmsys.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@RequestMapping(value = "/inputindex", method = RequestMethod.GET)
	private String inputIndex() {// 显示采购管理
		return "stock/input";
	}
	@RequestMapping(value = "/outputindex", method = RequestMethod.GET)
	private String outputIndex() {// 显示销售管理
		return "stock/output";
	}
	@RequestMapping(value = "/orderindex", method = RequestMethod.GET)
	private String orderIndex() {// 显示销售管理
		return "stock/order";
	}
}
