package com.supermarket.pssmsys.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Goods {
	//商品主键
	private Integer id;
	//商品名称
	private String name;
	//商品二级类别
	private Integer categoryLevel2Id;
	//库存量
	private Integer stockNumber;
	//进价
	private BigDecimal inputPrice;
	//售价
	private BigDecimal outputPrice;
	//供应商名称
	private String supplierName;
	//创建时间
	private Timestamp createTime;
	//编辑时间
	private Timestamp editTime;
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
	public Integer getCategoryLevel2Id() {
		return categoryLevel2Id;
	}
	public void setCategoryLevel2Id(Integer categoryLevel2Id) {
		this.categoryLevel2Id = categoryLevel2Id;
	}
	public Integer getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	public BigDecimal getInputPrice() {
		return inputPrice;
	}
	public void setInputPrice(BigDecimal inputPrice) {
		this.inputPrice = inputPrice;
	}
	public BigDecimal getOutputPrice() {
		return outputPrice;
	}
	public void setOutputPrice(BigDecimal outputPrice) {
		this.outputPrice = outputPrice;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
