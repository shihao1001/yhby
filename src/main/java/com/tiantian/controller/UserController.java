package com.tiantian.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.tiantian.common.Response;
import com.tiantian.common.ResponseUtils;
import com.tiantian.common.Ret;
import com.tiantian.domain.User;
import com.tiantian.domain.UserSession;
import com.tiantian.service.UserService;
import com.tiantian.util.CacheUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserService userService;
	
	
	@RequestMapping(value = "/captcha",produces="application/json")
	@ResponseBody
	public Object getCaptcha(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileno", required = true) String mobileno
			){
		
		
		
		return null;
	}
	
	@RequestMapping(value = "/login",produces="application/json")
	@ResponseBody
	public Object login(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileno", required = true) String mobileNo,
			@RequestParam(value = "captcha", required = true) String captcha,
			@RequestParam(value="__aeskey",required = false) String __aeskey
			){
		
		//logger
		logger.info("mobileno:"+mobileNo+"   captcha:"+captcha);
		
		if(!userService.checkCaptcha(mobileNo, captcha)){
			return ResponseUtils.instance(Ret.ERROR_CAPTCHA.code, Ret.ERROR_CAPTCHA.msg);
		}
		
		UserSession session = userService.login(mobileNo, captcha);
		User user = userService.getLoadedUser(mobileNo);
		System.out.println(session.getToken()+","+session.getSecret()+","+session.getUserId());
		//缓存用户信息
		CacheUtil.cacheUserInfo(new User(session.getUserId()), session);
		
		Map<String,Object> returnMap = new HashMap<String,Object>();
		
		returnMap.put("token", session.getToken());
		returnMap.put("secret", session.getSecret());
		returnMap.put("user", JSON.toJSONString(user));
		
		logger.info("token:"+session.getToken() + " ;"+"secret:"+session.getSecret());
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", Ret.SUCC.code);
		map.put("msg", Ret.SUCC.msg);
		map.put("data", returnMap);
		return map;
		//return ResponseUtils.succ(returnMap);
	}
	
	
	@RequestMapping(value = "/saveNickname",produces="application/json")
	@ResponseBody
	public Object saveNickname(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileno", required = true) String mobileNo,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "nickname",required = false) String nickname
			){
		logger.info("saveNickname:"+"   mobileNo="+mobileNo+",token="+token+",nickname="+nickname);
		//从缓存获得用户信息
		User user = (User) JSON.parseObject((String) CacheUtil.cacheMap.get("token_user_"+token), User.class);
		System.out.println("缓存用户信息为："+(String) CacheUtil.cacheMap.get("token_user_"+token));
		user.setNickName(nickname);
		try{
			userService.savaNickname(user);
			Thread.sleep(3000);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", Ret.SUCC.code);
			map.put("msg", Ret.SUCC.msg);
			map.put("data", "保存成功");
			return map;
		}catch(Exception e){
			return null;
		}
	}
	
	
	@RequestMapping(value = "/saveOwnLabel",produces="application/json")
	@ResponseBody
	public Object saveOwnLabel(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileno", required = true) String mobileNo,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "ownlabel",required = false) String ownlabel
			){
		logger.info("saveOwnLabel:"+"   mobileNo="+mobileNo+",token="+token+",ownlabel="+ownlabel);
		//从缓存获得用户信息
		User user = (User) JSON.parseObject((String) CacheUtil.cacheMap.get("token_user_"+token), User.class);
		System.out.println("缓存用户信息为："+(String) CacheUtil.cacheMap.get("token_user_"+token));
		user.setOwnLabel(ownlabel);
		try{
			userService.savaOwnLabel(user);
			Thread.sleep(10000);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", Ret.SUCC.code);
			map.put("msg", Ret.SUCC.msg);
			map.put("data", "保存成功");
			return map;
		}catch(Exception e){
			return null;
		}
		
		
	}
	
	
	@RequestMapping(value = "/saveOwnSign",produces="application/json")
	@ResponseBody
	public Object saveOwnSign(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileno", required = true) String mobileNo,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "ownsign",required = false) String ownsign
			){
		logger.info("saveOwnSign:"+"   mobileNo="+mobileNo+",token="+token+",ownsign="+ownsign);
		//从缓存获得用户信息
		User user = (User) JSON.parseObject((String) CacheUtil.cacheMap.get("token_user_"+token), User.class);
		System.out.println("缓存用户信息为："+(String) CacheUtil.cacheMap.get("token_user_"+token));
		user.setOwnSign(ownsign);
		try{
			userService.savaOwnSign(user);
			Thread.sleep(3000);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", Ret.SUCC.code);
			map.put("msg", Ret.SUCC.msg);
			map.put("data", "保存成功");
			
			return map;
		}catch(Exception e){
			return null;
		}
		
		
	}
	
	
	@RequestMapping(value = "/saveGender",produces="application/json")
	@ResponseBody
	public Object saveGender(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileno", required = true) String mobileNo,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "gender",required = false) String gender
			){
		logger.info("saveGender:"+"   mobileNo="+mobileNo+",token="+token+",gender="+gender);
		//从缓存获得用户信息
		User user = (User) JSON.parseObject((String) CacheUtil.cacheMap.get("token_user_"+token), User.class);
		System.out.println("缓存用户信息为："+(String) CacheUtil.cacheMap.get("token_user_"+token));
		if(null == gender || gender.equals("") ){
			//默认为男，1
			user.setGender(1);
		}else if(gender.equals("男")){
			user.setGender(1);
		}else if(gender.equals("女")){
			user.setGender(0);
		}
		
		try{
			userService.savaGender(user);
			Thread.sleep(3000);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", Ret.SUCC.code);
			map.put("msg", Ret.SUCC.msg);
			map.put("data", "保存成功");
			
			return map;
		}catch(Exception e){
			return null;
		}
		
		
	}


}
