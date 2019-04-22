package com.supermarket.pssmsys.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.supermarket.pssmsys.BaseTest;
import com.supermarket.pssmsys.entity.JobDepartment;

public class JobDepartmentServiceTest extends BaseTest{
	@Autowired
	private JobDepartmentService jobDepartmentService;
	
	@Test
	@Ignore
	public void insertTest() {
		JobDepartment targetItem=new JobDepartment();
		Date aimTDate = (new Date());
		//java.sql.Date aimSQLdate = new java.sql.Date(new java.util.Date().getTime());
		Timestamp aimTimestamp = new Timestamp(aimTDate.getTime());
		targetItem.setName("采购经理");
		targetItem.setContent("负责采购");
		targetItem.setCreateTime(aimTimestamp);
		targetItem.setEditTime(aimTimestamp);
		boolean result=jobDepartmentService.addJobDepartment(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void selectAllTest() {
		List<JobDepartment> jobDepartmentList=jobDepartmentService.getJobDepartmentAll();
		System.out.println(jobDepartmentList.size());
	}
	@Test
	@Ignore
	public void selectByTest() {
		JobDepartment targetItem=jobDepartmentService.getJobDepartmentById(1);
		System.out.println(targetItem.getName());
	}
	@Test
	@Ignore
	public void updateTest() {
		JobDepartment targetItem=new JobDepartment();
		targetItem.setId(1);
		targetItem.setName("人事主管1");
		boolean result=jobDepartmentService.updateJobDepartmentById(targetItem);
		System.out.println(result);
	}
	@Test
	@Ignore
	public void deleteTest() {
		boolean result=jobDepartmentService.deleteJobDepartmentById(2);
		System.out.println(result);
	}
}
