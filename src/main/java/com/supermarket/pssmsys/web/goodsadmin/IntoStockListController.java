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
import com.supermarket.pssmsys.entity.IntoStockList;
import com.supermarket.pssmsys.service.GoodsService;
import com.supermarket.pssmsys.service.IntoStockListService;
import com.supermarket.pssmsys.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/intostockadmin")
public class IntoStockListController {
	@Autowired
	private IntoStockListService intoStockListService;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/getinotstocklist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getInotStockListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<IntoStockList> intoStockList=intoStockListService.getIntoStockListAll();
		modelMap.put("intoStockList", intoStockList);
		return modelMap;
	}
	
	@RequestMapping(value = "/addintostock", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> addIntoStock( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String uniqueId=HttpServletRequestUtil.getString(request, "uniqueId");
		Integer goodsId=HttpServletRequestUtil.getInt(request, "goodsId");
		BigDecimal intoStockPrice=new BigDecimal(HttpServletRequestUtil.getString(request, "intoStockPrice"));
		
		String supplierName=HttpServletRequestUtil.getString(request, "supplierName");
		Integer intoStockNumber=HttpServletRequestUtil.getInt(request, "intoStockNumber");
		IntoStockList targetItem=new IntoStockList();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setGoodsId(goodsId);
		targetItem.setIsFinished(0);
		targetItem.setUniqueId(uniqueId);
		targetItem.setSupplierName(supplierName);
		targetItem.setIntoStockPrice(intoStockPrice);
		targetItem.setIntoStockNumber(intoStockNumber);
		targetItem.setEditTime(aimTimestamp);
		targetItem.setCreateTime(aimTimestamp);
		boolean result=intoStockListService.addIntoStockList(targetItem);
		modelMap.put("success", result);
		return modelMap;
	}
	/**
	 * 通过ID删除货单一行
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteintostockbyid", method = RequestMethod.GET)
	private String deleteIntoStockById(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id =Integer.parseInt(HttpServletRequestUtil.getString(request, "id")) ;
		Boolean result = intoStockListService.deleteIntoStockListById(id);
		modelMap.put("result", result);
		return "stock/input";
	}
	/**
	 * 通过ID设置货单一行为已完成
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/finishintostockbyid", method = RequestMethod.GET)
	private String finishIntoStockById(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id =Integer.parseInt(HttpServletRequestUtil.getString(request, "id")) ;
		Integer goodsId =Integer.parseInt(HttpServletRequestUtil.getString(request, "goodsId")) ;
		IntoStockList targetItem=new IntoStockList();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setId(id);
		targetItem.setIsFinished(1);
		Boolean result = intoStockListService.updateIntoStockListByIdOrUniqueId(targetItem);
		IntoStockList targetItemA=intoStockListService.getIntoStockListById(id);
		Goods targetItemB=goodsService.getGoodsById(goodsId);
		Integer formerStockNumber=targetItemB.getStockNumber();
		Integer newStockNumber=formerStockNumber+targetItemA.getIntoStockNumber();
		targetItemB.setStockNumber(newStockNumber);
		targetItemB.setEditTime(aimTimestamp);
		result=goodsService.updateGoodsById(targetItemB);
		modelMap.put("result", result);
		return "stock/input";
	}
}
