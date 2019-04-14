package com.supermarket.pssmsys.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class UserInfo {
	//用户信息主键
		private Integer id;
		//姓名
		private String name;
		//性别
		private Integer gender;
		//身份证号码
		private String idCard;
		//是否结婚
		private Integer isMarried;
		//部门编号
		//private Integer departmentId;
		//职位编号
		//private Integer positionId;
		//电话号码
		private String phone;
		//权限编号
		private Integer priority;
		//入职时间
		private Date entryTime;
		//转正时间
		private Date fullTime;
		//创建时间
		private Timestamp createTime;
		//修改时间
		private Timestamp editTime;
		//部门类
		private JobDepartment jobDepartment;
		//职位类
		private JobPosition jobPosition;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getGender() {
			return gender;
		}
		public void setGender(Integer gender) {
			this.gender = gender;
		}
		public String getIdCard() {
			return idCard;
		}
		public void setIdCard(String idCard) {
			this.idCard = idCard;
		}
		public Integer getIsMarried() {
			return isMarried;
		}
		public void setIsMarried(Integer isMarried) {
			this.isMarried = isMarried;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public Integer getPriority() {
			return priority;
		}
		public void setPriority(Integer priority) {
			this.priority = priority;
		}
		public Date getEntryTime() {
			return entryTime;
		}
		public void setEntryTime(Date entryTime) {
			this.entryTime = entryTime;
		}
		public Date getFullTime() {
			return fullTime;
		}
		public void setFullTime(Date fullTime) {
			this.fullTime = fullTime;
		}
		public Timestamp getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Timestamp createTime) {
			this.createTime = createTime;
		}
		public Timestamp getEditTime() {
			return editTime;
		}
		public void setEditTime(Timestamp editTime) {
			this.editTime = editTime;
		}
		public JobDepartment getJobDepartment() {
			return jobDepartment;
		}
		public void setJobDepartment(JobDepartment jobDepartment) {
			this.jobDepartment = jobDepartment;
		}
		public JobPosition getJobPosition() {
			return jobPosition;
		}
		public void setJobPosition(JobPosition jobPosition) {
			this.jobPosition = jobPosition;
		}
}
