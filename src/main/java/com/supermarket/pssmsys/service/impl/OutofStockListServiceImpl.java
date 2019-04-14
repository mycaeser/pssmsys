package com.supermarket.pssmsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.pssmsys.dao.OutofStockListDao;
import com.supermarket.pssmsys.entity.OutofStockList;
import com.supermarket.pssmsys.service.OutofStockListService;


@Service
public class OutofStockListServiceImpl implements OutofStockListService{
	@Autowired
	private OutofStockListDao outofStockListDao;
	
	@Override
	public List<OutofStockList> getOutofStockListAll(){
		List<OutofStockList> outofStockListList=outofStockListDao.queryOutofStockListAll();
		return outofStockListList;
	}
	@Override
	public OutofStockList getOutofStockListById(Integer id) {
		OutofStockList targetItem=new OutofStockList();
		targetItem.setId(id);
		List<OutofStockList> outofStockListList=outofStockListDao.queryOutofStockListBytargetItem(targetItem);
		return outofStockListList.get(0);
	}
	@Override
	public OutofStockList getOutofStockListByUniqueId(String uniqueId) {
		OutofStockList targetItem=new OutofStockList();
		targetItem.setUniqueId(uniqueId);
		List<OutofStockList> outofStockListList=outofStockListDao.queryOutofStockListBytargetItem(targetItem);
		return outofStockListList.get(0);
	}
	@Override
	public boolean updateOutofStockListByIdOrUniqueId(OutofStockList targetItem) {
		int effectedNum=outofStockListDao.updateOutofStockListByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean addOutofStockList(OutofStockList targetItem) {
		int effectedNum=outofStockListDao.insertIntoOutofStockListByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteOutofStockListById(Integer id) {
		OutofStockList targetItem=new OutofStockList();
		targetItem.setId(id);
		int effectedNum=outofStockListDao.deleteOutofStockListByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteOutofStockListByUniqueId(String uniqueId) {
		OutofStockList targetItem=new OutofStockList();
		targetItem.setUniqueId(uniqueId);
		int effectedNum=outofStockListDao.deleteOutofStockListByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
