package com.tiantian.domain;

import java.util.Date;

public class User {
	private Long userId;
	private String mobileNo = "";
	private String password = "";
	private String userName = "";
	private String nickName = "";
	private String identityId = "";
	private Integer isRealname = 0;
	private String homeAddr = "";
	private String communityName = "";
	private String companyAddr = "";
	private Integer gender = 1;
	private Date birthday = new Date();
	private String pictureUrl = "";
	private String ownSign = "";
	private String ownLabel = "";
	private Date createTime;
	private Date updateTime;

	public User(Long userId) {
		this.userId = userId;
	}

	public User(String mobileNo, String password) {
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public User() {

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIdentityId() {
		return identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public Integer getIsRealname() {
		return isRealname;
	}

	public void setIsRealname(Integer isRealname) {
		this.isRealname = isRealname;
	}

	public String getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getCompanyAddr() {
		return companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getOwnSign() {
		return ownSign;
	}

	public void setOwnSign(String ownSign) {
		this.ownSign = ownSign;
	}

	public String getOwnLabel() {
		return ownLabel;
	}

	public void setOwnLabel(String ownLabel) {
		this.ownLabel = ownLabel;
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
