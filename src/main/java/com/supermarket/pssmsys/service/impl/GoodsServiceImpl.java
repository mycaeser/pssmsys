package com.supermarket.pssmsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.pssmsys.dao.GoodsDao;
import com.supermarket.pssmsys.entity.Goods;
import com.supermarket.pssmsys.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<Goods> getGoodsAll(){
		List<Goods> goodsList=goodsDao.queryGoodsAll();
		return goodsList;
	}
	@Override
	public Goods getGoodsById(Integer id) {
		Goods targetItem=new Goods();
		targetItem.setId(id);
		List<Goods> goodsList=goodsDao.queryGoodsBytargetItem(targetItem);
		return goodsList.get(0);
	}
	@Override
	public boolean updateGoodsById(Goods targetItem) {
		int effectedNum=goodsDao.updateGoodsByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean addGoods(Goods targetItem) {
		int effectedNum=goodsDao.insertIntoGoodsByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteGoodsById(Integer id) {
		Goods targetItem=new Goods();
		targetItem.setId(id);
		int effectedNum=goodsDao.deleteGoodsByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
