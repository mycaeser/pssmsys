package com.supermarket.pssmsys.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.pssmsys.BaseTest;
import com.supermarket.pssmsys.entity.IntoStockList;

public class IntoStockListServiceTest extends BaseTest{
	@Autowired
	private IntoStockListService intoStockListService;
	
	@Test
	@Ignore
	public void insertTest() {
		IntoStockList targetItem=new IntoStockList();
		BigDecimal testPrice=new BigDecimal(5.5);
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setGoodsId(1);
		targetItem.setIntoStockNumber(50);
		targetItem.setIntoStockPrice(testPrice);
		targetItem.setSupplierName("娃哈哈XXX公司");
		targetItem.setUniqueId("20190422193910");
		targetItem.setIsFinished(0);
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setEditTime(aimTimestamp);
		boolean result=intoStockListService.addIntoStockList(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selectAllTest() {
		List<IntoStockList> intoStockListList=intoStockListService.getIntoStockListAll();
		System.out.println(intoStockListList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		IntoStockList targetItem=intoStockListService.getIntoStockListById(1);
		System.out.println(targetItem.getUniqueId());
	}
	@Test
	@Ignore
	public void updateTest() {
		IntoStockList targetItem=new IntoStockList();
		targetItem.setId(1);
		targetItem.setUniqueId("20190422193909");
		boolean result=intoStockListService.updateIntoStockListByIdOrUniqueId(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void deleteTest() {
		boolean result=intoStockListService.deleteIntoStockListById(2);
		System.out.println(result);
	}
}
