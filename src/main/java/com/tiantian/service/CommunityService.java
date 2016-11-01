package com.tiantian.service;

import java.util.List;

import com.tiantian.domain.City;
import com.tiantian.domain.Community;

public interface CommunityService {
	
	public List<City> getAllCity();
	
	public List<Community> getAllCommunityByCityId(Integer cityId);
	
	

}
