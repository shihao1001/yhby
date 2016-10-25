package com.tiantian.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.tiantian.domain.User;
import com.tiantian.domain.UserSession;


public class CacheUtil {
	
	public static ConcurrentHashMap<String,Object> cacheMap = new ConcurrentHashMap<String, Object>();
		
	public static boolean checkCaptcha(String mobileNo, String captcha){
		
		return true;
	}

	public static void cacheUserInfo(User user, UserSession session) {
		// 1)缓存 token
		
		cacheMap.putIfAbsent("mobileNo_token_"+user.getMobileNo(), session.getToken());
		// 2)缓存token对应secret
		cacheMap.putIfAbsent("token_secret_"+session.getToken(), session.getSecret());	
		// 3)缓存token对应用户信息
		cacheMap.putIfAbsent("token_user_"+session.getToken(), JSON.toJSONString(user));			
		// 4)缓存id对应用户信息
		cacheMap.putIfAbsent("userId_user_"+user.getUserId(), JSON.toJSONString(user));		
	}

	public static void unCacheUserInfo(User user, UserSession session) {
		cacheMap.remove("mobileNo_token_"+user.getMobileNo());
		cacheMap.remove("token_secret_"+session.getToken());
		cacheMap.remove("token_user_"+session.getToken());
		cacheMap.remove("userId_user_"+user.getUserId());	
	}

}
