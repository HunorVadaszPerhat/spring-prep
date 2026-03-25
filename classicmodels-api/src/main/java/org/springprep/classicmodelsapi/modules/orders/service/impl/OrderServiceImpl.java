package org.springprep.classicmodelsapi.modules.orders.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springprep.classicmodelsapi.infrastructure.exception.ResourceNotFoundException;
import org.springprep.classicmodelsapi.modules.customers.model.Customer;
import org.springprep.classicmodelsapi.modules.customers.repository.CustomerRepository;
import org.springprep.classicmodelsapi.modules.orders.dto.OrderDto;
import org.springprep.classicmodelsapi.modules.orders.mapper.OrderMapper;
import org.springprep.classicmodelsapi.modules.orders.model.Order;
import org.springprep.classicmodelsapi.modules.orders.repository.OrderRepository;
import org.springprep.classicmodelsapi.modules.orders.service.OrderService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }

    @Override
    public OrderDto findById(Integer orderNumber) {
        return orderMapper.toDto(getOrder(orderNumber));
    }

    @Override
    @Transactional
    public OrderDto create(OrderDto dto) {
        Order order = orderMapper.toEntity(dto);
        order.setCustomer(getCustomer(dto.customerNumber()));
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Override
    @Transactional
    public OrderDto update(Integer orderNumber, OrderDto dto) {
        Order existing = getOrder(orderNumber);
        existing.setOrderDate(dto.orderDate());
        existing.setRequiredDate(dto.requiredDate());
        existing.setShippedDate(dto.shippedDate());
        existing.setStatus(dto.status());
        existing.setComments(dto.comments());
        existing.setCustomer(getCustomer(dto.customerNumber()));
        return orderMapper.toDto(existing);
    }

    @Override
    @Transactional
    public void delete(Integer orderNumber) {
        orderRepository.delete(getOrder(orderNumber));
    }

    private Order getOrder(Integer orderNumber) {
        return orderRepository.findById(orderNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Order %d not found".formatted(orderNumber)));
    }

    private Customer getCustomer(Integer customerNumber) {
        return customerRepository.findById(customerNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer %d not found".formatted(customerNumber)));
    }
}
