package com.supermarket.pssmsys.web.goodscategoryadmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermarket.pssmsys.entity.GoodsCategory;
import com.supermarket.pssmsys.service.GoodsCategoryService;

@Controller
@RequestMapping("/goodscateadmin")
public class GoodsCategoryController {
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	@RequestMapping(value = "/getgoodscategorylist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getGoodsListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<GoodsCategory> goodsCategoryList=goodsCategoryService.getGoodsCategoryAll();
		modelMap.put("goodsCategoryList", goodsCategoryList);
		return modelMap;
	}

}
