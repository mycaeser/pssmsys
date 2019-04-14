package com.supermarket.pssmsys.service;

import java.util.List;

import com.supermarket.pssmsys.entity.IntoStockList;;

public interface IntoStockListService {
	/*
	 * 查询进货单信息
	 */
	List<IntoStockList> getIntoStockListAll();
	/*
	 * 通过主键查询进货单信息
	 */
	IntoStockList getIntoStockListById(Integer id);
	/*
	 * 通过进货单唯一编号查询
	 */
	IntoStockList getIntoStockListByUniqueId(String uniqueId);
	/*
	 * 更新一个进货单信息
	 */
	boolean updateIntoStockListByIdOrUniqueId(IntoStockList targetItem);
	/*
	 * 添加一个进货单信息
	 */
	boolean addIntoStockList(IntoStockList targetItem);
	/*
	 * 通过主键删除一个进货单信息
	 */
	boolean deleteIntoStockListById(Integer id);
	/*
	 * 通过进货单唯一编号删除多条进货单信息
	 */
	boolean deleteIntoStockListByUniqueId(String uniqueId);
}
