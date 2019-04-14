package com.supermarket.pssmsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.pssmsys.dao.IntoStockListDao;
import com.supermarket.pssmsys.entity.IntoStockList;
import com.supermarket.pssmsys.service.IntoStockListService;

@Service
public class IntoStockListServiceImpl implements IntoStockListService{
	@Autowired
	private IntoStockListDao intoStockListDao;
	
	@Override
	public List<IntoStockList> getIntoStockListAll(){
		List<IntoStockList> intoStockListList=intoStockListDao.queryIntoStockListAll();
		return intoStockListList;
	}
	@Override
	public IntoStockList getIntoStockListById(Integer id) {
		IntoStockList targetItem=new IntoStockList();
		targetItem.setId(id);
		List<IntoStockList> intoStockListList=intoStockListDao.queryIntoStockListBytargetItem(targetItem);
		return intoStockListList.get(0);
	}
	@Override
	public IntoStockList getIntoStockListByUniqueId(String uniqueId) {
		IntoStockList targetItem=new IntoStockList();
		targetItem.setUniqueId(uniqueId);
		List<IntoStockList> intoStockListList=intoStockListDao.queryIntoStockListBytargetItem(targetItem);
		return intoStockListList.get(0);
	}
	@Override
	public boolean updateIntoStockListByIdOrUniqueId(IntoStockList targetItem) {
		int effectedNum=intoStockListDao.updateIntoStockListByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean addIntoStockList(IntoStockList targetItem) {
		int effectedNum=intoStockListDao.insertIntoIntoStockListByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteIntoStockListById(Integer id) {
		IntoStockList targetItem=new IntoStockList();
		targetItem.setId(id);
		int effectedNum=intoStockListDao.deleteIntoStockListByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteIntoStockListByUniqueId(String uniqueId) {
		IntoStockList targetItem=new IntoStockList();
		targetItem.setUniqueId(uniqueId);
		int effectedNum=intoStockListDao.deleteIntoStockListByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
