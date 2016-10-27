package com.tiantian.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiantian.common.ResponseUtils;
import com.tiantian.common.Ret;
import com.tiantian.domain.User;
import com.tiantian.domain.UserSession;
import com.tiantian.exception.SrvException;
import com.tiantian.service.UserService;
import com.tiantian.util.CacheUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/getUserByToken",produces="application/json")
	@ResponseBody
	public Object getUserByToken(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "token", required = true) String token){
		    logger.info("token :"+token);
			User user = userService.getUserByToken(token);
			return ResponseUtils.instance(0, "success",user);		
	}

	@RequestMapping(value = "/register",produces="application/json")
	@ResponseBody
	public Object register(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileNo", required = true) String mobileNo,
			@RequestParam(value = "password", required = true) String password
			){
		try {
			userService.registerUser(mobileNo, password);
			return ResponseUtils.instance(0, "register successfully");
		} catch (SrvException e) {
			logger.error("register user [ mobileNo="+mobileNo+",password="+password+"] SrvException", e);
			return ResponseUtils.instance(e.getErrNo(), e.getMsg());
		} catch (Exception e){
			logger.error("register user [ mobileNo="+mobileNo+",password="+password+"] Exception", e);
		}	
		return ResponseUtils.instance(Ret.UNKOWN_ERROR.getErrno(), Ret.UNKOWN_ERROR.getMsg());
		
	}
	
	@RequestMapping(value = "/login",produces="application/json")
	@ResponseBody
	public Object login(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileNo", required = true) String mobileNo,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value="__aeskey",required = false) String __aeskey
			){
		
		//logger
		logger.info("mobileno:"+mobileNo+"   password:"+password);	
		try {
			UserSession session = userService.login(mobileNo, password);
			return ResponseUtils.instance(0, "login successfully", session);
		} catch (SrvException e) {
			logger.error("login user [ mobileNo="+mobileNo+",password="+password+"] SrvException", e);
			return ResponseUtils.instance(e.getErrNo(), e.getMsg());
		} catch (Exception e){
			logger.error("login user [ mobileNo="+mobileNo+",password="+password+"] Exception", e);	
		}
		return ResponseUtils.instance(Ret.UNKOWN_ERROR.getErrno(), Ret.UNKOWN_ERROR.getMsg());
		
	}
	
	
	@RequestMapping(value = "/saveNickname",produces="application/json")
	@ResponseBody
	public Object saveNickname(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileNo", required = true) String mobileNo,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "nickName",required = false) String nickName
			){
		logger.info("saveNickname:"+"   mobileNo="+mobileNo+",token="+token+",nickname="+nickName);
	    User user = new User();
	    user.setMobileNo(mobileNo);
	    user.setNickName(nickName);
		userService.savaNickname(user);
		return ResponseUtils.instance(0, "保存成功");			
	}
	
	
	@RequestMapping(value = "/saveOwnLabel",produces="application/json")
	@ResponseBody
	public Object saveOwnLabel(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileNo", required = true) String mobileNo,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "ownLabel",required = false) String ownLabel
			){
		logger.info("saveOwnLabel:"+"   mobileNo="+mobileNo+",token="+token+",ownlabel="+ownLabel);
		User user = new User();
		user.setMobileNo(mobileNo);
		user.setOwnLabel(ownLabel);
		userService.savaOwnLabel(user);
		return ResponseUtils.instance(0, "保存成功");
	}
	
	
	@RequestMapping(value = "/saveOwnSign",produces="application/json")
	@ResponseBody
	public Object saveOwnSign(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileNo", required = true) String mobileNo,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "ownSign",required = false) String ownSign
			){
		logger.info("saveOwnSign:"+"   mobileNo="+mobileNo+",token="+token+",ownsign="+ownSign);
		User user = new User();
		user.setMobileNo(mobileNo);
		user.setOwnSign(ownSign);
		userService.savaOwnSign(user);
		return ResponseUtils.instance(0, "保存成功");	
	}
	
	@RequestMapping(value = "/saveCommunityName",produces="application/json")
	@ResponseBody
	public Object saveCommunityName(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileNo", required = true) String mobileNo,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "communityName",required = false) String communityName
			){
		logger.info("saveOwnSign:"+"   mobileNo="+mobileNo+",token="+token+",communityName="+communityName);
		User user = new User();
		user.setMobileNo(mobileNo);
		user.setCommunityName(communityName);
		userService.savaCommunityName(user);
		return ResponseUtils.instance(0, "保存成功");	
	}
	
	@RequestMapping(value = "/saveHomeAddress",produces="application/json")
	@ResponseBody
	public Object saveHomeAddress(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileNo", required = true) String mobileNo,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "homeAddress",required = false) String homeAddress
			){
		logger.info("saveOwnSign:"+"   mobileNo="+mobileNo+",token="+token+",homeAddress="+homeAddress);
		User user = new User();
		user.setMobileNo(mobileNo);
		user.setHomeAddr(homeAddress);
		userService.savaHomeAddress(user);
		return ResponseUtils.instance(0, "保存成功");	
	}
	
	
	@RequestMapping(value = "/saveGender",produces="application/json")
	@ResponseBody
	public Object saveGender(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "mobileNo", required = true) String mobileNo,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "gender",required = false) String gender
			){
		logger.info("saveGender:"+"   mobileNo="+mobileNo+", token="+token+", gender="+gender);
		User user = new User();
		user.setMobileNo(mobileNo);
		if(null == gender || gender.equals("") ){
			user.setGender(1);
		}else if(gender.equals("男")){
			user.setGender(1);
		}else if(gender.equals("女")){
			user.setGender(0);
		}
		userService.savaGender(user);
		return ResponseUtils.instance(0, "保存成功");	
		
	}


}
