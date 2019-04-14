package com.supermarket.pssmsys.service;

import java.util.List;

import com.supermarket.pssmsys.entity.GoodsCategory;;

public interface GoodsCategoryService {
	/*
	 * 查询全部商品类别
	 */
	List<GoodsCategory> getGoodsCategoryAll();
	/*
	 * 通过主键查询商品类别
	 */
	GoodsCategory getGoodsCategoryById(Integer id);
	/*
	 * 更新一个商品类别
	 */
	boolean updateGoodsCategoryById(GoodsCategory targetItem);
	/*
	 * 添加一个商品类别
	 */
	boolean addGoodsCategory(GoodsCategory targetItem);
	/*
	 * 删除一个商品类别
	 */
	boolean deleteGoodsCategoryById(Integer id);
}
