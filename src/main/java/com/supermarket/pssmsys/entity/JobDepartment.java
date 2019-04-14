package com.supermarket.pssmsys.entity;

import java.sql.Timestamp;

public class JobDepartment {
	//部门编号
		private long id;
		//部门名称
		private String name;
		//部门职能介绍
		private String content;
		//创建时间
		private Timestamp createdTime;
		//修改时间
		private Timestamp editedTime;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Timestamp getCreatedTime() {
			return createdTime;
		}
		public void setCreatedTime(Timestamp createdTime) {
			this.createdTime = createdTime;
		}
		public Timestamp getEditedTime() {
			return editedTime;
		}
		public void setEditedTime(Timestamp editedTime) {
			this.editedTime = editedTime;
		}
}
