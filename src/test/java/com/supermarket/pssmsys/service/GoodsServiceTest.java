package com.supermarket.pssmsys.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.pssmsys.BaseTest;
import com.supermarket.pssmsys.entity.Goods;

public class GoodsServiceTest extends BaseTest{
	@Autowired
	private GoodsService goodsService;
	
	@Test
	public void testSelect() {
		List<Goods> goodsList=goodsService.getGoodsAll();
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.println(goodsList.get(i).getName());
		}
	}
}
