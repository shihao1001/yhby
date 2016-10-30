package com.tiantian.domain;

public class UserAndSession extends User {
	
	private String token;
	private String secret;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	public UserAndSession(){}
	
	public UserAndSession(User user,UserSession session){
		this.birthday = user.getBirthday();
		this.cityId = user.getCityId();
		this.communityId = user.getCommunityId();
		this.communityName = user.getCommunityName();
		this.companyAddr = user.getCompanyAddr();
		this.gender= user.getGender();
		this.homeAddr = user.getHomeAddr();
		this.identityId= user.getIdentityId();
		this.isRealname = user.getIsRealname();
		this.mobileNo = user.getMobileNo();
		this.nickName = user.getNickName();
		this.ownLabel = user.getOwnLabel();
		this.ownSign = user.getOwnSign();
		this.pictureUrl = user.getPictureUrl();
		
		this.token = session.getToken();
		this.secret = session.getSecret();
	}

}
