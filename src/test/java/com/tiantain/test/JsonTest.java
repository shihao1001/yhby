package com.tiantain.test;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.tiantian.domain.Community;

public class JsonTest {
	
	@Test
	public void testString2Bean(){
		String text = "{\"cityId\":1,\"communityAddress\":\"上海市宝山区祁华路58弄\",\"communityId\":1,\"communityName\":\"葑润华庭北1区小区\",\"latitude\":0,\"longitude\":0}";
		Community community = JSON.parseObject(text, Community.class);
		System.out.println(community.getCommunityName());
	}

}
