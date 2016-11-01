package com.tiantian.service.impl;

import com.tiantian.mapper.AdviceMapper;
import com.tiantian.service.AdviceService;

public class AdviceServiceImpl implements AdviceService {
	
	private AdviceMapper adviceMapper;

	@Override
	public void makeAdvice(String advice, Long userId) {
		adviceMapper.makeAdvice(advice, userId);

	}

}
