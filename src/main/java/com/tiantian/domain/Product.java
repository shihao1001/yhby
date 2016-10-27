package com.tiantian.domain;

import java.util.Date;

public class Product {
	private Long productId;
	private int productTypeId;
	private Long userId;
	private String productTitle;
	private String productSummary;
	private String productPic;
	private Integer productPrice;
	private String productUnit;
	private Integer productStatus;
	private Date createTime;
	private Date updateTime;
	
	
	public Product(){}
	
	public Product(int productTypeId,Long userId,String productTitle,String productSummary,String productPic,Integer productPrice,String productUnit,Integer productStatus){
		this.productTypeId = productTypeId;
		this.userId = userId;
		this.productTitle = productTitle;
		this.productSummary = productSummary;
		this.productPic = productPic;
		this.productPrice = productPrice;
		this.productUnit = productUnit;
		this.productStatus = productStatus;
		
	}
	
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductSummary() {
		return productSummary;
	}
	public void setProductSummary(String productSummary) {
		this.productSummary = productSummary;
	}
	public String getProductPic() {
		return productPic;
	}
	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	

}
