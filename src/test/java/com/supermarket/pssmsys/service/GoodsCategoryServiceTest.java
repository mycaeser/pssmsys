package com.supermarket.pssmsys.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.pssmsys.BaseTest;
import com.supermarket.pssmsys.entity.GoodsCategory;

public class GoodsCategoryServiceTest extends BaseTest{
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	@Test
	@Ignore
	public void testInsertInto() {
		GoodsCategory targetItem=new GoodsCategory();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setName("111文体箱包");
		targetItem.setEditTime(aimTimestamp);
		targetItem.setCreateTime(aimTimestamp);
		boolean result=goodsCategoryService.addGoodsCategory(targetItem);
		System.out.println(result);
		
	}
	@Test
	@Ignore
	public void testSelectAll() {
		List<GoodsCategory> goodsCategoryList=goodsCategoryService.getGoodsCategoryAll();
		System.out.println(goodsCategoryList.size());
	}
	@Test
	@Ignore
	public void testSelectOne() {
		GoodsCategory targetItem=goodsCategoryService.getGoodsCategoryById(50);
		System.out.println(targetItem.getName());
	}
	@Test
	@Ignore
	public void testUpdate() {
		GoodsCategory targetItem=new GoodsCategory();
		targetItem.setId(50);
		targetItem.setName("玩具");
		boolean result=goodsCategoryService.updateGoodsCategoryById(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void testDelete() {
		boolean result=goodsCategoryService.deleteGoodsCategoryById(51);
		System.out.println(result);
	}
}
