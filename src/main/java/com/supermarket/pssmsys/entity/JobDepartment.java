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
		private Timestamp createTime;
		//修改时间
		private Timestamp editTime;
		
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
		
}
