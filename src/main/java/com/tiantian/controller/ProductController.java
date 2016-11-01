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
import com.tiantian.domain.Product;
import com.tiantian.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/createProduct",produces="application/json")
	@ResponseBody
	public Object createProduct(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "productTypeId", required = true) Integer productTypeId,
			@RequestParam(value = "userId", required = true) Long userId,
			@RequestParam(value = "productTitle", required = true) String productTitle,
			@RequestParam(value = "productSummary", required = true) String productSummary,
			@RequestParam(value = "productPic", required = true) String productPic,
			@RequestParam(value = "productPrice", required = true) Integer productPrice,
			@RequestParam(value = "productUnit", required = true) String productUnit
			){
		logger.info("createProduct :[cuserId="+userId+",productTypeId="+productTypeId+",productTitle="+productTitle+","
				+ "productSummary="+productSummary+",productPic="+productPic+",]");
		try{
			Product product = new Product(productTypeId,userId,productTitle,productSummary,productPic,productPrice,productUnit,1);
			productService.createProduct(product);
			return ResponseUtils.instance(0, "创建成功");	
		}catch(Exception e){
			logger.error("createProduct error", e);
		}
		return ResponseUtils.instance(Ret.UNKOWN_ERROR.getErrno(), Ret.UNKOWN_ERROR.getMsg());
	}
	

}
