package com.tiantian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiantian.domain.User;
import com.tiantian.mapper.UserMapper;
import com.tiantian.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService{
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUserByToken(String token){
		return userMapper.getUserByToken(token);		
	}

}
