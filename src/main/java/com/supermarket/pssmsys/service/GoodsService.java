package com.supermarket.pssmsys.service;

import java.util.List;

import com.supermarket.pssmsys.entity.Goods;;

public interface GoodsService {
	/*
	 * 查询全部商品
	 */
	List<Goods> getGoodsAll();
	/*
	 * 通过主键查询商品
	 */
	Goods getGoodsById(Integer id);
	/*
	 * 更新一个商品
	 */
	boolean updateGoodsById(Goods targetItem);
	/*
	 * 添加一个商品
	 */
	boolean addGoods(Goods targetItem);
	/*
	 * 删除一个商品
	 */
	boolean deleteGoodsById(Integer id);
}
