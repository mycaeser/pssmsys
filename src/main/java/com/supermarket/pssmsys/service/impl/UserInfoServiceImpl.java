package com.supermarket.pssmsys.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.pssmsys.dao.UserInfoDao;
import com.supermarket.pssmsys.entity.UserInfo;
import com.supermarket.pssmsys.service.UserInfoService;



@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public List<UserInfo> getUserInfoAll(){
		List<UserInfo> userInfoList=userInfoDao.queryUserInfoAll();
		return userInfoList;
	}
	
	@Override
	public UserInfo getUserInfoById(Integer id) {
		UserInfo someone=new UserInfo();
		someone.setId(id);
		List<UserInfo> userInfoList=userInfoDao.queryUserInfoBySomeone(someone);
		return userInfoList.get(0);
	}
	
	@Override
	public UserInfo getUserInfoByIdCard(String idCard) {
		UserInfo someone=new UserInfo();
		someone.setIdCard(idCard);
		List<UserInfo> userInfoList=userInfoDao.queryUserInfoBySomeone(someone);
		return userInfoList.get(0);
	}
	
	@Override
	public boolean addUserInfo(UserInfo someone) {
		int effectedNum=userInfoDao.insertIntoUserInfoBySomeone(someone);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean updateUserInfoFullTime(Integer id,java.sql.Date fullTime) {
		UserInfo someone=new UserInfo();
		Date aimTDate = new Date();
		Timestamp editedTime = new Timestamp(aimTDate.getTime());
		someone.setId(id);
		someone.setFullTime(fullTime);
		someone.setEditTime(editedTime);
		int effectedNum=userInfoDao.updateUserInfoBySomeone(someone);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteUserInfo(Integer id) {
		UserInfo someone=new UserInfo();
		someone.setId(id);
		int effectedNum=userInfoDao.deleteUserInfoBySomeone(someone);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean updateUserInfo(UserInfo someone) {
		int effectedNum=userInfoDao.updateUserInfoBySomeone(someone);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public List<UserInfo> getUserInfoListByIdcardLike(String idCard){
		UserInfo someone=new UserInfo();
		someone.setIdCard(idCard);
		List<UserInfo> userInfoList=userInfoDao.queryUserInfoByIdCardLike(someone);
		return userInfoList;
	}
	@Override
	public List<UserInfo> getUserInfoAllNotFulljob(){
		List<UserInfo> userInfoList=userInfoDao.queryUserInfoAllnotFulljob();
		return userInfoList;
	}
}
