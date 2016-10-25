package com.tiantian.dao;

import com.tiantian.domain.UserSession;
import com.tiantian.domain.User;

public interface UserDao {
	
	public Integer saveUser(User user);
	public User getUserByMobile(String mobileno);
	public void saveUserSession(UserSession session);
	public void saveNickname(User user);
	public void saveOwnLabel(User user);
	public void saveOwnSign(User user);
	public void saveGender(User user);
	
}
