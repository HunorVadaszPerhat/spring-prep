package org.springprep.classicmodelsapi.modules.orders.service;

import org.springprep.classicmodelsapi.modules.orders.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> findAll();

    OrderDto findById(Integer orderNumber);

    OrderDto create(OrderDto dto);

    OrderDto update(Integer orderNumber, OrderDto dto);

    void delete(Integer orderNumber);
}
