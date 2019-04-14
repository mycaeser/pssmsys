package com.supermarket.pssmsys.service;

import java.util.List;

import com.supermarket.pssmsys.entity.JobPosition;


public interface JobPositionService {
	/*
	 * 查询全部职位
	 */
	List<JobPosition> getJobPositionListAll();
	/*
	 * 通过主键查询职位
	 */
	JobPosition getJobPositionById(Integer id);
	/*
	 * 添加一个职位
	 */
	boolean updateJobPosition(JobPosition targetItem);
	/*
	 * 添加一个职位
	 */
	boolean addJobPosition(JobPosition targetItem);
	/*
	 * 删除一条职位
	 */
	boolean deleteJobPositionById(Integer id);
}
