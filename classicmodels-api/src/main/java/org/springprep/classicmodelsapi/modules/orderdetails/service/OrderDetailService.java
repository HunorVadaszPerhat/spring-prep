package org.springprep.classicmodelsapi.modules.orderdetails.service;

import org.springprep.classicmodelsapi.modules.orderdetails.dto.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetailDto> findAll();

    OrderDetailDto findById(Integer orderNumber, String productCode);

    OrderDetailDto create(OrderDetailDto dto);

    OrderDetailDto update(Integer orderNumber, String productCode, OrderDetailDto dto);

    void delete(Integer orderNumber, String productCode);
}
