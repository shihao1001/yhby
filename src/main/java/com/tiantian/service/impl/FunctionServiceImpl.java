package com.tiantian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiantian.domain.ProductType;
import com.tiantian.mapper.ProductTypeMapper;
import com.tiantian.service.FunctionService;

@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	private ProductTypeMapper productTypeMapper;
	
	@Override
	public List<ProductType> getFunctions() {
		return productTypeMapper.getFunctions();		
	}

}
