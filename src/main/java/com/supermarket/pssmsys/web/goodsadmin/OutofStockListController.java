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
import com.supermarket.pssmsys.entity.OutofStockList;
import com.supermarket.pssmsys.service.GoodsService;
import com.supermarket.pssmsys.service.OutofStockListService;
import com.supermarket.pssmsys.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/outstockadmin")
public class OutofStockListController {
	@Autowired
	private OutofStockListService outofStockListService;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/getoutstocklist", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getInotStockListAll( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<OutofStockList> outofStockList=outofStockListService.getOutofStockListAll();
		modelMap.put("outofStockList", outofStockList);
		return modelMap;
	}
	@RequestMapping(value = "/addoutstock", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> addIntoStock( HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String uniqueId=HttpServletRequestUtil.getString(request, "uniqueId");
		Integer goodsId=HttpServletRequestUtil.getInt(request, "goodsId");
		BigDecimal outofStockPrice=new BigDecimal(HttpServletRequestUtil.getString(request, "outofStockPrice"));
		
		String supplierName=HttpServletRequestUtil.getString(request, "supplierName");
		Integer outofStockNumber=HttpServletRequestUtil.getInt(request, "outofStockNumber");
		OutofStockList targetItem=new OutofStockList();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setGoodsId(goodsId);
		targetItem.setIsFinished(0);
		targetItem.setUniqueId(uniqueId);
		targetItem.setSupplierName(supplierName);
		targetItem.setOutofStockNumber(outofStockNumber);
		targetItem.setOutofStockPrice(outofStockPrice);
		targetItem.setEditTime(aimTimestamp);
		targetItem.setCreateTime(aimTimestamp);
		boolean result=outofStockListService.addOutofStockList(targetItem);
		modelMap.put("success", result);
		return modelMap;
	}
	/**
	 * 通过ID删除货单一行
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteoutstockbyid", method = RequestMethod.GET)
	private String deleteIntoStockById(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id =Integer.parseInt(HttpServletRequestUtil.getString(request, "id")) ;
		Boolean result = outofStockListService.deleteOutofStockListById(id);
		modelMap.put("result", result);
		return "stock/output";
	}
	/**
	 * 通过ID设置货单一行为已完成
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/finishoutstockbyid", method = RequestMethod.GET)
	private String finishIntoStockById(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer id =Integer.parseInt(HttpServletRequestUtil.getString(request, "id")) ;
		Integer goodsId =Integer.parseInt(HttpServletRequestUtil.getString(request, "goodsId")) ;
		OutofStockList targetItem=new OutofStockList();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setId(id);
		targetItem.setIsFinished(1);
		Boolean result = outofStockListService.updateOutofStockListByIdOrUniqueId(targetItem);
		OutofStockList targetItemA=outofStockListService.getOutofStockListById(id);
		Goods targetItemB=goodsService.getGoodsById(goodsId);
		Integer formerStockNumber=targetItemB.getStockNumber();
		Integer newStockNumber=formerStockNumber-targetItemA.getOutofStockNumber();
		targetItemB.setStockNumber(newStockNumber);
		targetItemB.setEditTime(aimTimestamp);
		result=goodsService.updateGoodsById(targetItemB);
		modelMap.put("result", result);
		return "stock/input";
	}
}
