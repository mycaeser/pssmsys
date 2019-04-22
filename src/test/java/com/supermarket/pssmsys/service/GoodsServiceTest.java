package com.supermarket.pssmsys.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.pssmsys.BaseTest;
import com.supermarket.pssmsys.entity.Goods;

public class GoodsServiceTest extends BaseTest{
	@Autowired
	private GoodsService goodsService;
	
	@Test
	@Ignore
	public void testSelect() {
		List<Goods> goodsList=goodsService.getGoodsAll();
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.println(goodsList.get(i).getName());
		}
	}
	@Test
	@Ignore
	public void testSelectBy() {
		Goods targetItem=goodsService.getGoodsById(1);
		System.out.println(targetItem.getName());
	}
	@Test
	@Ignore
	public void insertTest() {
		Goods targetItem=new Goods();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setName("雪碧");
		targetItem.setStockNumber(13);
		targetItem.setCategoryLevel2Id(10101);
		BigDecimal testPrice=new BigDecimal(4.5);
		targetItem.setInputPrice(testPrice);
		targetItem.setOutputPrice(testPrice);
		targetItem.setSupplierName("娃哈哈XX公司");
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setEditTime(aimTimestamp);
		boolean result=goodsService.addGoods(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void updateTest() {
		Goods targetItem=new Goods();
		targetItem.setId(2);
		targetItem.setName("雪碧1");
		boolean result=goodsService.updateGoodsById(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void deleteTest() {
		boolean result=goodsService.deleteGoodsById(2);
		System.out.println(result);
	}
}
