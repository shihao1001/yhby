package com.tiantian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiantian.domain.Order;

public interface OrderMapper {
	
	public void placeOrder(Order order);
	/**
	 * 每页5条数据
	 * */
	public List<Order> getPayoutOrders(@Param("userId") Long userId, @Param("lastOrderId") Long lastOrderId);
	
	
	public List<Order> getPayoutOrdersWithSeller(@Param("userId") Long userId, @Param("lastOrderId") Long lastOrderId);
	
	
	public List<Order> getIncomeOrders(@Param("userId") Long userId, @Param("lastOrderId") Long lastOrderId);

}
