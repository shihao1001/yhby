package com.tiantian.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tiantian.dao.UserDao;
import com.tiantian.domain.UserSession;
import com.tiantian.domain.User;
import com.tiantian.service.UserService;
import com.tiantian.util.CacheUtil;
import com.tiantian.util.RandomToken;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	public UserDao userDao;


	@Override
	public UserSession login(String mobileNo, String captcha) {
		User user = userDao.getUserByMobile(mobileNo);
		UserSession session = new UserSession();
		RandomToken randomToken = RandomToken.genToken();
		session.setToken(randomToken.getToken());
		session.setSecret(randomToken.getSecret());
		
		
		//用户不存在，保存
		if(user == null){
			User user2 = new User();
			user2.setMobileNo(mobileNo);
			userDao.saveUser(user2);	
			session.setUserId(user2.getUserId());
		}else{
			
			session.setUserId(user.getUserId());
		}	
		
		userDao.saveUserSession(session);
		
		return session;
		
	}

	@Override
	public boolean checkCaptcha(String mobileNo, String captcha) {
		boolean isSussLogin = CacheUtil.checkCaptcha(mobileNo,captcha);
		return isSussLogin;
	}

	@Override
	public void savaNickname(User user) {
		userDao.saveNickname(user);	
	}

	@Override
	public void savaOwnLabel(User user) {
		userDao.saveOwnLabel(user);
		
	}

	@Override
	public void savaOwnSign(User user) {
		userDao.saveOwnSign(user);
		
	}

	@Override
	public void savaGender(User user) {
		userDao.saveGender(user);
		
	}

	@Override
	public User getLoadedUser(String mobileNo) {
		return userDao.getUserByMobile(mobileNo);
	}
	
	

}
