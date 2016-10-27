package com.tiantian.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiantian.domain.Product;
import com.tiantian.mapper.ProductMapper;
import com.tiantian.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	public ProductMapper productMapper;
	
	@Override
	public void createProduct(Product product) {
		productMapper.createProduct(product);
	}

}
