package com.supermarket.pssmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.supermarket.pssmsys.entity.GoodsCategory;

public interface GoodsCategoryDao {
	/*
	 * 查询 pssm_goods_category 表，select * from pssm_goods_category
	 */
	List<GoodsCategory> queryGoodsCategoryAll();
	/*
	 * 根据具体项查询 pssm_goods_category 表
	 * 
	 */
	List<GoodsCategory> queryGoodsCategoryBytargetItem(@Param("targetItem")GoodsCategory targetItem);
	/*
	 * 插入 pssm_goods_category 表具体项
	 * 
	 */
	int insertIntoGoodsCategoryByTargetItem(@Param("targetItem")GoodsCategory targetItem);
	/*
	 * 更新 pssm_goods_category 一条
	 * 只允许通过编号
	 */
	int updateGoodsCategoryByTargetItem(@Param("targetItem")GoodsCategory targetItem);
	/*
	 * 删除 pssm_goods_category 一条
	 * 只允许通过编号
	 */
	int deleteGoodsCategoryByTargetItem(@Param("targetItem")GoodsCategory targetItem);
}
