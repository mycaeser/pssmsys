package com.supermarket.pssmsys.entity;

import java.sql.Timestamp;

public class IntoStockList {
	//进货单主键
	private Integer id;
	//进货单唯一编号
	private String uniqueId;
	//商品编号
	private Integer goodsId;
	//进货数量
	private Integer intoStockNumber;
	//进货价格
	private Integer intoStockPrice;
	//进货是否完成
	private Integer isFinished;
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
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getIntoStockNumber() {
		return intoStockNumber;
	}
	public void setIntoStockNumber(Integer intoStockNumber) {
		this.intoStockNumber = intoStockNumber;
	}
	public Integer getIntoStockPrice() {
		return intoStockPrice;
	}
	public void setIntoStockPrice(Integer intoStockPrice) {
		this.intoStockPrice = intoStockPrice;
	}
	public Integer getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(Integer isFinished) {
		this.isFinished = isFinished;
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
