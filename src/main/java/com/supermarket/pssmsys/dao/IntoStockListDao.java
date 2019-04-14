package com.supermarket.pssmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.supermarket.pssmsys.entity.IntoStockList;;

public interface IntoStockListDao {
	/*
	 * 查询 pssm_into_stock_list 表，select * from pssm_into_stock_list
	 */
	List<IntoStockList> queryIntoStockListAll();
	/*
	 * 根据具体项查询 pssm_into_stock_list 表
	 * 例如，进货唯一编号、商品ID
	 */
	List<IntoStockList> queryIntoStockListBytargetItem(@Param("targetItem")IntoStockList targetItem);
	/*
	 * 插入 pssm_into_stock_list 表具体项
	 * 
	 */
	int insertIntoIntoStockListByTargetItem(@Param("targetItem")IntoStockList targetItem);
	/*
	 * 更新 pssm_into_stock_list 一条
	 * 允许通过编号 进货唯一编号
	 */
	int updateIntoStockListByTargetItem(@Param("targetItem")IntoStockList targetItem);
	/*
	 * 删除 pssm_into_stock_list 一条
	 * 允许通过编号 进货唯一编号
	 */
	int deleteIntoStockListByTargetItem(@Param("targetItem")IntoStockList targetItem);
}
