package com.supermarket.pssmsys.service;

import java.util.List;

import com.supermarket.pssmsys.entity.OutofStockList;

public interface OutofStockListService {
	/*
	 * 查询出货单信息
	 */
	List<OutofStockList> getOutofStockListAll();
	/*
	 * 通过主键查询出货单信息
	 */
	OutofStockList getOutofStockListById(Integer id);
	/*
	 * 通过出货单唯一编号查询
	 */
	OutofStockList getOutofStockListByUniqueId(String uniqueId);
	/*
	 * 更新一个出货单信息
	 */
	boolean updateOutofStockListByIdOrUniqueId(OutofStockList targetItem);
	/*
	 * 添加一个出货单信息
	 */
	boolean addOutofStockList(OutofStockList targetItem);
	/*
	 * 通过主键删除一个出货单信息
	 */
	boolean deleteOutofStockListById(Integer id);
	/*
	 * 通过出货单唯一编号删除多条出货单信息
	 */
	boolean deleteOutofStockListByUniqueId(String uniqueId);
}
