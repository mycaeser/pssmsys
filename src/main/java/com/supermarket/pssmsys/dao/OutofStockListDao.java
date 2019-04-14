package com.supermarket.pssmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.supermarket.pssmsys.entity.OutofStockList;;

public interface OutofStockListDao {
	/*
	 * 查询 pssm_outof_stock_list 表，select * from pssm_outof_stock_list
	 */
	List<OutofStockList> queryOutofStockListAll();
	/*
	 * 根据具体项查询 pssm_outof_stock_list 表
	 * 例如，出货唯一编号、商品ID
	 */
	List<OutofStockList> queryOutofStockListBytargetItem(@Param("targetItem")OutofStockList targetItem);
	/*
	 * 插入 pssm_outof_stock_list 表具体项
	 * 
	 */
	int insertIntoOutofStockListByTargetItem(@Param("targetItem")OutofStockList targetItem);
	/*
	 * 更新 pssm_outof_stock_list 一条
	 * 允许通过编号 出货唯一编号
	 */
	int updateOutofStockListByTargetItem(@Param("targetItem")OutofStockList targetItem);
	/*
	 * 删除 pssm_outof_stock_list 一条
	 * 允许通过编号 出货唯一编号
	 */
	int deleteOutofStockListByTargetItem(@Param("targetItem")OutofStockList targetItem);
}
