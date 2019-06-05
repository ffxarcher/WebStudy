package com.sq.order.service;

import com.sq.order.dto.OrderDto;
import org.springframework.stereotype.Service;


public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderDto
     * @return
     */
    OrderDto create(OrderDto orderDto);
}
