package com.supermarket.pssmsys.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.pssmsys.BaseTest;
import com.supermarket.pssmsys.entity.OutofStockList;

public class OutofStockListServiceTest extends BaseTest{
	@Autowired
	private OutofStockListService outofStockListService;
	
	@Test
	@Ignore
	public void insertTest() {
		OutofStockList targetItem=new OutofStockList();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setUniqueId("2019042302");
		targetItem.setGoodsId(1);
		targetItem.setIsFinished(0);
		targetItem.setOutofStockNumber(40);
		BigDecimal testPrice=new BigDecimal(55.5);
		targetItem.setOutofStockPrice(testPrice);
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setEditTime(aimTimestamp);
		targetItem.setSupplierName("娃哈哈XXX公司");
		boolean result=outofStockListService.addOutofStockList(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selectAllTest() {
		List<OutofStockList> outofStockListList=outofStockListService.getOutofStockListAll();
		System.out.println(outofStockListList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		OutofStockList targetItem=outofStockListService.getOutofStockListById(1);
		System.out.println(targetItem.getSupplierName());
	}
	@Test
	@Ignore
	public void updateTest() {
		OutofStockList targetItem=new OutofStockList();
		targetItem.setId(1);
		targetItem.setSupplierName("超级大公司食品旗舰企业");
		boolean result=outofStockListService.updateOutofStockListByIdOrUniqueId(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void deleteTest() {
		boolean result=outofStockListService.deleteOutofStockListById(2);
		System.out.println(result);
	}
}
