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
import com.tiantian.service.AdviceService;
import com.tiantian.service.TokenService;

@Controller
@RequestMapping("/advice")
public class AdviceController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	
	@Autowired
	private AdviceService adviceService;
	
	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value = "/makeAdvice",produces="application/json")
	@ResponseBody
	public Object makeAdvice(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "advice", required = true) String advice){
		logger.info("token:"+ token +" ,advice=" + advice);	
		try{
			User loginUser = tokenService.getUserByToken(token);
			if(loginUser == null){
				ResponseUtils.instance(Ret.请先登录.getErrno(), Ret.请先登录.getMsg());
			}
			adviceService.makeAdvice(advice, loginUser.getUserId());
			return ResponseUtils.instance(0, "保存成功");	
		} catch(Exception e){
			logger.error("makeAdvice error", e);
		}
		return ResponseUtils.instance(Ret.UNKOWN_ERROR.getErrno(), Ret.UNKOWN_ERROR.getMsg());
	}

}
