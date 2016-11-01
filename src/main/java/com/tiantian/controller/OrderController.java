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
import com.tiantian.domain.Order;
import com.tiantian.domain.User;
import com.tiantian.service.AdviceService;
import com.tiantian.service.OrderService;
import com.tiantian.service.TokenService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value = "/placeOrder",produces="application/json")
	@ResponseBody
	public Object placeOrder(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "productId", required = true) Long productId,
			@RequestParam(value = "quantity", required = true) Integer quantity
			){
		logger.info("token:"+ token);	
		try{
			User loginUser = tokenService.getUserByToken(token);
			if(loginUser == null){
				return ResponseUtils.instance(Ret.请先登录.getErrno(), Ret.请先登录.getMsg());
			}
			Order order = new Order();
			order.setProductId(productId);
			order.setBuyerId(loginUser.getUserId());
			order.setQuantity(quantity);
			Order processedOrder = orderService.placeOrder(order);
			return ResponseUtils.instance(0, "保存成功",processedOrder);	
		} catch(Exception e){
			logger.error("place order error", e);
		}
		return ResponseUtils.instance(Ret.UNKOWN_ERROR.getErrno(), Ret.UNKOWN_ERROR.getMsg());
	}

}
