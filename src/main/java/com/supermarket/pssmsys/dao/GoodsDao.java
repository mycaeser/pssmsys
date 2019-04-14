package com.supermarket.pssmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.supermarket.pssmsys.entity.Goods;;

public interface GoodsDao {
	/*
	 * 查询 pssm_goods 表，select * from pssm_goods
	 */
	List<Goods> queryGoodsAll();
	/*
	 * 根据具体项查询 pssm_goods 表
	 * 例如，商品名或者类别查询
	 */
	List<Goods> queryGoodsBytargetItem(@Param("targetItem")Goods targetItem);
	/*
	 * 插入 pssm_goods 表具体项
	 * 
	 */
	int insertIntoGoodsByTargetItem(@Param("targetItem")Goods targetItem);
	/*
	 * 更新 pssm_goods 一条
	 * 只允许通过编号
	 */
	int updateGoodsByTargetItem(@Param("targetItem")Goods targetItem);
	/*
	 * 删除 pssm_goods 一条
	 * 只允许通过编号
	 */
	int deleteGoodsByTargetItem(@Param("targetItem")Goods targetItem);
}
