package com.tiantian.service;

import com.tiantian.domain.User;


public interface TokenService {
	
	public User getUserByToken(String token);

}
