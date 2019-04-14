package com.supermarket.pssmsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.pssmsys.dao.JobPositionDao;
import com.supermarket.pssmsys.entity.JobPosition;
import com.supermarket.pssmsys.service.JobPositionService;



@Service
public class JobPositionServiceImpl implements JobPositionService{
	@Autowired
	private JobPositionDao jobPositionDao;
	

	@Override
	public List<JobPosition> getJobPositionListAll(){
		List<JobPosition> jobPositionList=jobPositionDao.queryJobPositionAll();
		return jobPositionList;
	}
	@Override
	public JobPosition getJobPositionById(Integer id) {
		JobPosition targetItem=new JobPosition();
		targetItem.setId(id);
		List<JobPosition> jobPositionList=jobPositionDao.queryJobPositionByTargetItem(targetItem);
		return jobPositionList.get(0);
	}
	@Override
	public boolean addJobPosition(JobPosition targetItem) {
		int effectedNum=jobPositionDao.insertIntoJobPositionByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean deleteJobPositionById(Integer id) {
		JobPosition targetItem=new JobPosition();
		targetItem.setId(id);
		int effectedNum=jobPositionDao.deleteJobPositionByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
	@Override
	public boolean updateJobPosition(JobPosition targetItem) {
		int effectedNum=jobPositionDao.updateJobPositionByTargetItem(targetItem);
		return effectedNum > 0 ? true:false;
	}
}
