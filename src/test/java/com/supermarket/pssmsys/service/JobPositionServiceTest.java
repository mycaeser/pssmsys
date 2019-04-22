package com.supermarket.pssmsys.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.pssmsys.BaseTest;
import com.supermarket.pssmsys.entity.JobPosition;

public class JobPositionServiceTest extends BaseTest{
	@Autowired
	private JobPositionService jobPositionService;
	
	@Test
	@Ignore
	public void inserTest() {
		JobPosition targetItem=new JobPosition();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setName("人事专员");
		targetItem.setContent("负责招聘");
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setEditTime(aimTimestamp);
		boolean result=jobPositionService.addJobPosition(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selecAllTest() {
		List<JobPosition> jobPositionList=jobPositionService.getJobPositionListAll();
		System.out.println(jobPositionList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		JobPosition targetItem=jobPositionService.getJobPositionById(1);
		System.out.println(targetItem.getName());
	}
	@Test
	@Ignore
	public void updateTest() {
		JobPosition targetItem=new JobPosition();
		targetItem.setId(1);
		targetItem.setName("采购专员1");
		boolean result=jobPositionService.updateJobPosition(targetItem);
		System.out.println(result);
	}
	@Test
	public void deleteTest() {
		boolean result=jobPositionService.deleteJobPositionById(2);
		System.out.println(result);
	}
}
