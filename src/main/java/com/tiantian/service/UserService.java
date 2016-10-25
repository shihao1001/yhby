package com.tiantian.service;

import com.tiantian.domain.User;
import com.tiantian.domain.UserSession;

public interface UserService {
	public UserSession login(String mobileno, String captcha);

	public boolean checkCaptcha(String mobileNo, String captcha);

	public void savaNickname(User user);

	public void savaOwnLabel(User user);

	public void savaOwnSign(User user);

	public void savaGender(User user);

	public User getLoadedUser(String mobileNo);

	
}
