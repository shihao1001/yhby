package com.tiantian.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiantian.common.Ret;
import com.tiantian.domain.UserAndSession;
import com.tiantian.domain.UserSession;
import com.tiantian.domain.Community;
import com.tiantian.domain.User;
import com.tiantian.exception.SrvException;
import com.tiantian.mapper.CommunityMapper;
import com.tiantian.mapper.UserMapper;
import com.tiantian.service.UserService;
import com.tiantian.util.RandomToken;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	public UserMapper userMapper;
	
	@Autowired
	public CommunityMapper communityMapper;
	
	
	@Override
	public User getUserByToken(String token) {
		return userMapper.getUserByToken(token);
	}
	
	@Override
	public boolean registerUser(String mobileNo, String password) throws SrvException{
		User user = this.getUser(mobileNo);
		if(user != null){
			throw new SrvException(Ret.用户已存在_不允许注册.getErrno(),Ret.用户已存在_不允许注册.getMsg());
		}
		return userMapper.saveUser(new User(mobileNo,password)) == 1 ? true : false;
	}


	@Override
	public UserAndSession login(String mobileNo, String password) throws SrvException{
		User user = userMapper.getUserByMobile(mobileNo);
		if(user == null){
			throw new SrvException(Ret.用户不存在_请先注册再登录.getErrno(),Ret.用户不存在_请先注册再登录.getMsg());
		}
		if(!user.getPassword().equals(password)){
			throw new SrvException(Ret.用户或者密码不正确.getErrno(),Ret.用户或者密码不正确.getMsg());
		}
		UserSession session = new UserSession();
		RandomToken randomToken = RandomToken.genToken();
		session.setToken(randomToken.getToken());
		session.setSecret(randomToken.getSecret());
		
		session.setUserId(user.getUserId());
		userMapper.saveUserSession(session);	
		
		UserAndSession userAndSession = new UserAndSession(user,session);
		return userAndSession;
		
	}

	

	@Override
	public void savaNickname(User user) {
		userMapper.saveNickname(user);	
	}

	@Override
	public void savaOwnLabel(User user) {
		userMapper.saveOwnLabel(user);
		
	}

	@Override
	public void savaOwnSign(User user) {
		userMapper.saveOwnSign(user);
		
	}

	@Override
	public void savaGender(User user) {
		userMapper.saveGender(user);
		
	}

	@Override
	public User getUser(String mobileNo) {
		return userMapper.getUserByMobile(mobileNo);
	}

	@Override
	public void savaCommunityName(User user) {
		userMapper.savaCommunity(user);		
	}

	@Override
	public void savaHomeAddress(User user) {
		userMapper.savaHomeAddress(user);
	}

	@Override
	public boolean saveCommunity(Integer cityId, Long communityId, Long userId) {
		Community community = communityMapper.getCommunityById(communityId);
		User user = new User();
		user.setUserId(userId);
		user.setCommunityId(community.getCommunityId());
		user.setCommunityName(community.getCommunityName());
		user.setCityId(community.getCityId());
		Integer line = userMapper.savaCommunity(user);	
		if(line == 1){
			return true;
		}
		return false;
	}
}
