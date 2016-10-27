package com.tiantian.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class Community {
	private Long communityId;
	private String communityName;
	private String communityAddress;
	private Double latitude;
	private Double longitude;
	@JSONField(serialize = false)
	private Integer communityStatus;
	private Integer cityId;
	public Long getCommunityId() {
		return communityId;
	}
	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getCommunityAddress() {
		return communityAddress;
	}
	public void setCommunityAddress(String communityAddress) {
		this.communityAddress = communityAddress;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getCommunityStatus() {
		return communityStatus;
	}
	public void setCommunityStatus(Integer communityStatus) {
		this.communityStatus = communityStatus;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	

}
