package com.tiantian.mapper;

import com.tiantian.domain.UserSession;
import com.tiantian.domain.User;

public interface UserMapper {
	
	public Integer saveUser(User user);
	public User getUserByMobile(String mobileno);
	public void saveUserSession(UserSession session);
	public void saveNickname(User user);
	public void saveOwnLabel(User user);
	public void saveOwnSign(User user);
	public void saveGender(User user);
	
	public User getUserByToken(String token);
	public Integer savaCommunity(User user);
	public void savaHomeAddress(User user);
	
}
