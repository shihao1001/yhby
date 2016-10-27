package com.tiantian.mapper;

import java.util.List;

import com.tiantian.domain.City;
import com.tiantian.domain.Community;

public interface CommunityMapper {
	
	public List<Community> getAllCommunityByCityId(Integer cityId);
	
	public List<City> getAllCity();

}
