package com.supermarket.pssmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.supermarket.pssmsys.entity.JobDepartment;


public interface JobDepartmentDao {
	/*
	 * 查询 pssm_job_department 表，select * from pssm_job_department
	 */
	List<JobDepartment> queryJobDepartmentAll();
	/*
	 * 根据具体项查询 pssm_job_department 表
	 * 例如，根据部门编号、部门名称查询
	 */
	List<JobDepartment> queryJobDeparTmentBytargetItem(@Param("targetItem")JobDepartment targetItem);
	/*
	 * 插入 pssm_job_department 表具体项
	 * 
	 */
	int insertIntoJobDepartmentByTargetItem(@Param("targetItem")JobDepartment targetItem);
	/*
	 * 更新 pssm_job_department 一条
	 * 只允许通过编号、部门名称更新
	 */
	int updateJobDepartmentByTargetItem(@Param("targetItem")JobDepartment targetItem);
	/*
	 * 删除 pssm_job_department 一条
	 * 只允许通过编号、部门名称删除
	 */
	int deleteJobDepartmentByTargetItem(@Param("targetItem")JobDepartment targetItem);
}
