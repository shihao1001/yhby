package com.tiantian.controller;

import java.util.List;

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
import com.tiantian.domain.Community;
import com.tiantian.domain.Product;
import com.tiantian.domain.User;
import com.tiantian.service.CommunityService;
import com.tiantian.service.TokenService;
import com.tiantian.service.UserService;

@Controller
@RequestMapping("/community")
public class CommunityController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	
	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value = "/getCommunityByCityId",produces="application/json")
	@ResponseBody
	public Object getCommunityByCityId(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "cityId", required = true) Integer cityId
			){
		logger.info("getCommunityByCityId :[cityId=" + cityId + ", token=" + token +"]");
		try{
			List<Community> communityList = communityService.getAllCommunityByCityId(cityId);
			return ResponseUtils.instance(0, "success",communityList);	
		}catch(Exception e){
			logger.error("getCommunityByCityId error", e);
		}
		return ResponseUtils.instance(Ret.UNKOWN_ERROR.getErrno(), Ret.UNKOWN_ERROR.getMsg());
	}
	
	@RequestMapping(value = "/saveCommunity",produces="application/json")
	@ResponseBody
	public Object saveCommunity(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "cityId", required = true) Integer cityId,
			@RequestParam(value = "communityId", required = true) Long communityId
			){
		logger.info("saveCommunity :[cityId=" + cityId + ", token=" + token +", communityId="+ communityId +"]");
		try{
			User user = tokenService.getUserByToken(token);
			if(user != null){
				if(userService.saveCommunity(cityId, communityId, user.getUserId())){
					return ResponseUtils.instance(0, "success");
				}else 
					return ResponseUtils.instance(Ret.UNKOWN_ERROR.getErrno(), Ret.UNKOWN_ERROR.getMsg());
					
			}else{
				ResponseUtils.instance(Ret.请先登录.getErrno(), Ret.请先登录.getMsg());
			}
		}catch(Exception e){
			logger.error("getCommunityByCityId error", e);
		}
		return ResponseUtils.instance(Ret.UNKOWN_ERROR.getErrno(), Ret.UNKOWN_ERROR.getMsg());
	}

}
