package com.tiantian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiantian.domain.Order;
import com.tiantian.domain.Product;
import com.tiantian.mapper.OrderMapper;
import com.tiantian.mapper.ProductMapper;
import com.tiantian.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public Order placeOrder(Order order) {
		Product product = productMapper.getProductById(order.getProductId());
		order.setPrice(product.getProductPrice());
		order.setSellerId(product.getUserId());
		orderMapper.placeOrder(order);
		order.setProduct(product);
		return order;
	}

}
