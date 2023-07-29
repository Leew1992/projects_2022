package org.example.service;

import org.example.mapper.dto.CommonResult;
import org.example.mapper.entity.Order;

public interface OrderService {
    /**
     * 创建订单数据
     * @param order
     */
    CommonResult create(Order order);
}