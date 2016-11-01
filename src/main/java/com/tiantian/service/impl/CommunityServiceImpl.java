package com.tiantian.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiantian.domain.City;
import com.tiantian.domain.Community;
import com.tiantian.mapper.CommunityMapper;
import com.tiantian.service.CommunityService;

@Service
public class CommunityServiceImpl implements CommunityService {
	
    private static final Logger logger = LoggerFactory.getLogger(CommunityServiceImpl.class);
	
	@Autowired
	public CommunityMapper communityMapper;

	@Override
	public List<City> getAllCity() {		
		return communityMapper.getAllCity();
	}

	@Override
	public List<Community> getAllCommunityByCityId(Integer cityId) {
		return communityMapper.getAllCommunityByCityId(cityId);
	}


}
