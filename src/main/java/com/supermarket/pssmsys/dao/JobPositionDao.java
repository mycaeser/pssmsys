package com.supermarket.pssmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.supermarket.pssmsys.entity.JobPosition;


public interface JobPositionDao {
	/*
	 * 查询 pssm_job_position 表，select * from pssm_job_position
	 */
	List<JobPosition> queryJobPositionAll();
	/*
	 * 根据具体项 查询 pssm_job_position 表
	 * 只允许根据编号、职位名称 查询
	 */
	List<JobPosition> queryJobPositionByTargetItem(@Param("targetItem") JobPosition targetItem);
	/*
	 * 插入 pssm_job_position 表一条
	 */
	int insertIntoJobPositionByTargetItem(@Param("targetItem") JobPosition targetItem);
	/*
	 * 更新 pssm_job_position 表一条
	 * 只允许根据编号更新
	 */
	int updateJobPositionByTargetItem(@Param("targetItem") JobPosition targetItem);
	/*
	 * 删除 pssm_job_position 表一条
	 * 只允许根据编号删除
	 */
	int deleteJobPositionByTargetItem(@Param("targetItem") JobPosition targetItem);
}
