package com.supermarket.pssmsys.service;

import java.sql.Date;
import java.util.List;

import com.supermarket.pssmsys.entity.UserInfo;


public interface UserInfoService {
	/*
	 * 获取未转正的人信息
	 */
	List<UserInfo> getUserInfoAllNotFulljob();
	/*
	 * 获取全部个人信息
	 */
	List<UserInfo> getUserInfoAll();
	/*
	 * 根据身份证模糊获取信息
	 */
	List<UserInfo> getUserInfoListByIdcardLike(String idCard);
	/*
	 * 通过主键获取一个人的信息
	 */
	UserInfo getUserInfoById(Integer id);
	/*
	 * 通过身份证获取信息
	 */
	UserInfo getUserInfoByIdCard(String idCard);
	/*
	 * 添加一个人的信息入数据库
	 */
	boolean addUserInfo(UserInfo someone);
	/*
	 * 转正，添加转正时间
	 */
	boolean updateUserInfo(UserInfo someone);
	/*
	 * 转正，添加转正时间
	 */
	boolean updateUserInfoFullTime(Integer id,Date fullTime);
	/*
	 * 删除一条记录
	 */
	boolean deleteUserInfo(Integer id);
}
