package com.supermarket.pssmsys.service;

import java.util.List;

import com.supermarket.pssmsys.entity.JobDepartment;


public interface JobDepartmentService {
	/*
	 * 查询全部部门
	 */
	List<JobDepartment> getJobDepartmentAll();
	/*
	 * 通过主键查询部门
	 */
	JobDepartment getJobDepartmentById(Integer id);
	/*
	 * 更新一个部门
	 */
	boolean updateJobDepartmentById(JobDepartment targetItem);
	/*
	 * 添加一个部门
	 */
	boolean addJobDepartment(JobDepartment targetItem);
	/*
	 * 删除一个部门
	 */
	boolean deleteJobDepartmentById(Integer id);
}
