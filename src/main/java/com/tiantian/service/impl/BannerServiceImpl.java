package com.tiantian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tiantian.domain.Banner;
import com.tiantian.mapper.BannerMapper;
import com.tiantian.service.BannerService;

public class BannerServiceImpl implements BannerService {
	
	@Autowired
	private BannerMapper bannerMapper;

	@Override
	public List<Banner> getBanners() {
		return bannerMapper.getBanners();
	}

}
