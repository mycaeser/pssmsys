package com.supermarket.pssmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.supermarket.pssmsys.entity.UserInfo;


public interface UserInfoDao {
	/*
	 * 查询 未转正的人
	 * 
	 */
	List<UserInfo> queryUserInfoAllnotFulljob();
	/*
	 * 查询 pssm_user_info 表，select * from user_info
	 * 
	 */
	List<UserInfo> queryUserInfoAll();
	/*
	 * 根据范围查询 pssm_user_info 表
	 * 例如：queryUserInfoByRange(0,500)表示查询0到500的数据
	 */
	List<UserInfo> queryUserInfoByRange(@Param("start")int start,@Param("end")int end);
	/*
	 * 根据someone的信息查询 pssm_user_info 表
	 * 例如：someone.setUserId(1);queryUserInfoByUserId(someone);表示查询ID为1的信息 
	 * 只允许通过主键、姓名、性别、身份证，是否已婚、部门、职位、电话号、入职时间查询
	 */
	List<UserInfo> queryUserInfoBySomeone(@Param("someone")UserInfo someone);
	/*
	 * 根据someone的信息查询 pssm_user_info 表
	 * 根据idcard身份证模糊查询
	 * 
	 */
	List<UserInfo> queryUserInfoByIdCardLike(@Param("someone")UserInfo someone);
	/*
	 * 根据someone的信息插入pssm_user_info表
	 * 
	 */
	int insertIntoUserInfoBySomeone(@Param("someone")UserInfo someone);
	/*
	 * 根据someone的信息更新一条pssm_user_info记录
	 * 不能修改名字和身份证
	 */
	int updateUserInfoBySomeone(@Param("someone")UserInfo someone);
	/*
	 * 根据someone的信息更新一条pssm_user_info记录
	 * 通过ID只能修改名字和身份证
	 */
	int updateUserInfoBySomeoneOnlyChangeNameOrIDcard(@Param("someone")UserInfo someone);
	/*
	 * 根据someone的信息删除一条pssm_user_info记录
	 */
	int deleteUserInfoBySomeone(@Param("someone")UserInfo someone);
}
