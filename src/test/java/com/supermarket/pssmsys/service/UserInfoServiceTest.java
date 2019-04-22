package com.supermarket.pssmsys.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.pssmsys.BaseTest;
import com.supermarket.pssmsys.entity.JobDepartment;
import com.supermarket.pssmsys.entity.JobPosition;
import com.supermarket.pssmsys.entity.UserInfo;

public class UserInfoServiceTest extends BaseTest{
	@Autowired
	private UserInfoService  userInfoService;
	
	@Test
	@Ignore
	public void insertTest() {
		UserInfo targetItem=new UserInfo();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setName("王洪");
		targetItem.setPhone("18566802273");
		targetItem.setGender(1);
		targetItem.setIdCard("421307199712135563");
		targetItem.setIsMarried(0);
		JobDepartment jb=new JobDepartment();
		jb.setId(1);
		JobPosition jbp=new JobPosition();
		jbp.setId(1);
		targetItem.setJobDepartment(jb);
		targetItem.setJobPosition(jbp);
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setEditTime(aimTimestamp);
		targetItem.setPriority(1);
		boolean result=userInfoService.addUserInfo(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selectAllTest() {
		List<UserInfo> userInfoList=userInfoService.getUserInfoAll();
		System.out.println(userInfoList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		UserInfo targetItem=userInfoService.getUserInfoById(1);
		System.out.println(targetItem.getName());
	}
	@Test
	public void updateTest() {
		UserInfo targetItem=new UserInfo();
		targetItem.setId(1);
		targetItem.setName("李想封");
		boolean result=userInfoService.updateUserInfo(targetItem);
		System.out.println(result);
	}
}
