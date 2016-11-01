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
import com.tiantian.domain.ProductType;
import com.tiantian.domain.User;
import com.tiantian.service.AdviceService;
import com.tiantian.service.FunctionService;
import com.tiantian.service.TokenService;

@Controller
@RequestMapping("/function")
public class FunctionController {
	
private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	
	@Autowired
	private FunctionService functionService;
	
	
	@RequestMapping(value = "/functions",produces="application/json")
	@ResponseBody
	public Object functions(HttpServletRequest request,HttpServletResponse response){		
		try{
			List<ProductType> functions = functionService.getFunctions();
			return ResponseUtils.instance(0, "success", functions);	
		} catch(Exception e){
			logger.error("functions error", e);
		}
		return ResponseUtils.instance(Ret.UNKOWN_ERROR.getErrno(), Ret.UNKOWN_ERROR.getMsg());
	}

}
