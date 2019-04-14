package com.supermarket.pssmsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.pssmsys.dao.GoodsCategoryDao;
import com.supermarket.pssmsys.entity.GoodsCategory;
import com.supermarket.pssmsys.service.GoodsCategoryService;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService{
	@Autowired
	private GoodsCategoryDao goodsCategoryDao;
	
	@Override
	public List<GoodsCategory> getGoodsCategoryAll(){
		List<GoodsCategory> goodsCategoryList=goodsCategoryDao.queryGoodsCategoryAll();
		return goodsCategoryList;
	}
	@Override
	public GoodsCategory getGoodsCategoryById(Integer id) {
		GoodsCategory targetItem=new GoodsCategory();
		targetItem.setId(id);
		List<GoodsCategory> goodsCategoryList=goodsCategoryDao.queryGoodsCategoryBytargetItem(targetItem);
		return goodsCategoryList.get(0);
	}
	@Override
	public boolean updateGoodsCategoryById(GoodsCategory targetItem) {
		int effectedNum=goodsCategoryDao.updateGoodsCategoryByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean addGoodsCategory(GoodsCategory targetItem) {
		int effectedNum=goodsCategoryDao.insertIntoGoodsCategoryByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteGoodsCategoryById(Integer id) {
		GoodsCategory targetItem=new GoodsCategory();
		targetItem.setId(id);
		int effectedNum=goodsCategoryDao.deleteGoodsCategoryByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
