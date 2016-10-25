package com.tiantian.service;

import com.tiantian.domain.User;
import com.tiantian.domain.UserSession;
import com.tiantian.exception.SrvException;

public interface UserService {
	
	public User getUserByToken(String token);
	
	public boolean registerUser(String mobileNo,String password) throws SrvException;
	
	public UserSession login(String mobileNo, String password) throws SrvException;


	public void savaNickname(User user);

	public void savaOwnLabel(User user);

	public void savaOwnSign(User user);

	public void savaGender(User user);

	public User getUser(String mobileNo);
	

	
}
