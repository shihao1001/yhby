package com.tiantian.mapper;

import org.apache.ibatis.annotations.Param;

public interface AdviceMapper {
	
	public void makeAdvice(@Param("advice") String advice, @Param("userId") Long userId);

}
