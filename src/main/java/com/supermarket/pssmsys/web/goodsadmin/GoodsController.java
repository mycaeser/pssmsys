package com.supermarket.pssmsys.web.goodsadmin;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supermarket.pssmsys.entity.Goods;
import com.supermarket.pssmsys.service.GoodsService;
import com.supermarket.pssmsys.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/goodsadmin")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/getgoodslist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getGoodsListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Goods> goodsList=goodsService.getGoodsAll();
		modelMap.put("goodsList", goodsList);
		return modelMap;
	}
	
	@RequestMapping(value = "/updategoodsbyitem", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> updateGoodsByItem( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id=HttpServletRequestUtil.getInt(request, "id");
		String name=HttpServletRequestUtil.getString(request, "name");
		Integer categoryLevel2Id=HttpServletRequestUtil.getInt(request, "categoryLevel2Id");
		BigDecimal inputPrice=new BigDecimal(HttpServletRequestUtil.getString(request, "inputPrice"));
		BigDecimal outputPrice=new BigDecimal(HttpServletRequestUtil.getString(request, "outputPrice"));
		String supplierName=HttpServletRequestUtil.getString(request, "supplierName");
		Integer stockNumber=HttpServletRequestUtil.getInt(request, "stockNumber");
		Goods targetItem=new Goods();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setId(id);
		targetItem.setName(name);
		targetItem.setCategoryLevel2Id(categoryLevel2Id);
		targetItem.setInputPrice(inputPrice);
		targetItem.setOutputPrice(outputPrice);
		targetItem.setStockNumber(stockNumber);
		targetItem.setSupplierName(supplierName);
		targetItem.setEditTime(aimTimestamp);
		boolean result=goodsService.updateGoodsById(targetItem);
		modelMap.put("success", result);
		return modelMap;
	}
	@RequestMapping(value = "/addgoods", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> adddGoods( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String name=HttpServletRequestUtil.getString(request, "name");
		Integer categoryLevel2Id=HttpServletRequestUtil.getInt(request, "categoryLevel2Id");
		BigDecimal inputPrice=new BigDecimal(HttpServletRequestUtil.getString(request, "inputPrice"));
		BigDecimal outputPrice=new BigDecimal(HttpServletRequestUtil.getString(request, "outputPrice"));
		String supplierName=HttpServletRequestUtil.getString(request, "supplierName");
		Integer stockNumber=HttpServletRequestUtil.getInt(request, "stockNumber");
		Goods targetItem=new Goods();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setName(name);
		targetItem.setCategoryLevel2Id(categoryLevel2Id);
		targetItem.setInputPrice(inputPrice);
		targetItem.setOutputPrice(outputPrice);
		targetItem.setStockNumber(stockNumber);
		targetItem.setSupplierName(supplierName);
		targetItem.setEditTime(aimTimestamp);
		targetItem.setCreateTime(aimTimestamp);
		boolean result=goodsService.addGoods(targetItem);
		modelMap.put("success", result);
		return modelMap;
	}
	/**
	 * 通过ID删除商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deletegoodsbyid", method = RequestMethod.GET)
	private String deleteGoodsById(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id =Integer.parseInt(HttpServletRequestUtil.getString(request, "id")) ;
		Boolean result = goodsService.deleteGoodsById(id);
		modelMap.put("result", result);
		return "goods/list";
	}
}
