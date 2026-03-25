package org.springprep.classicmodelsapi.modules.orderdetails.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springprep.classicmodelsapi.infrastructure.exception.ResourceNotFoundException;
import org.springprep.classicmodelsapi.modules.orderdetails.dto.OrderDetailDto;
import org.springprep.classicmodelsapi.modules.orderdetails.mapper.OrderDetailMapper;
import org.springprep.classicmodelsapi.modules.orderdetails.model.OrderDetail;
import org.springprep.classicmodelsapi.modules.orderdetails.model.OrderDetailId;
import org.springprep.classicmodelsapi.modules.orderdetails.repository.OrderDetailRepository;
import org.springprep.classicmodelsapi.modules.orderdetails.service.OrderDetailService;
import org.springprep.classicmodelsapi.modules.orders.model.Order;
import org.springprep.classicmodelsapi.modules.orders.repository.OrderRepository;
import org.springprep.classicmodelsapi.modules.products.model.Product;
import org.springprep.classicmodelsapi.modules.products.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetailDto> findAll() {
        return orderDetailRepository.findAll().stream().map(orderDetailMapper::toDto).toList();
    }

    @Override
    public OrderDetailDto findById(Integer orderNumber, String productCode) {
        return orderDetailMapper.toDto(getOrderDetail(orderNumber, productCode));
    }

    @Override
    @Transactional
    public OrderDetailDto create(OrderDetailDto dto) {
        OrderDetail orderDetail = orderDetailMapper.toEntity(dto);
        orderDetail.setOrder(getOrder(dto.orderNumber()));
        orderDetail.setProduct(getProduct(dto.productCode()));
        return orderDetailMapper.toDto(orderDetailRepository.save(orderDetail));
    }

    @Override
    @Transactional
    public OrderDetailDto update(Integer orderNumber, String productCode, OrderDetailDto dto) {
        OrderDetail existing = getOrderDetail(orderNumber, productCode);
        if (!orderNumber.equals(dto.orderNumber()) || !productCode.equals(dto.productCode())) {
            throw new IllegalArgumentException("Order detail key cannot be changed during update");
        }
        existing.setQuantityOrdered(dto.quantityOrdered());
        existing.setPriceEach(dto.priceEach());
        existing.setOrderLineNumber(dto.orderLineNumber());
        existing.setOrder(getOrder(orderNumber));
        existing.setProduct(getProduct(productCode));
        return orderDetailMapper.toDto(orderDetailRepository.save(existing));
    }

    @Override
    @Transactional
    public void delete(Integer orderNumber, String productCode) {
        orderDetailRepository.delete(getOrderDetail(orderNumber, productCode));
    }

    private OrderDetail getOrderDetail(Integer orderNumber, String productCode) {
        return orderDetailRepository.findById(new OrderDetailId(orderNumber, productCode))
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Order detail %d/%s not found".formatted(orderNumber, productCode)));
    }

    private Order getOrder(Integer orderNumber) {
        return orderRepository.findById(orderNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Order %d not found".formatted(orderNumber)));
    }

    private Product getProduct(String productCode) {
        return productRepository.findById(productCode)
                .orElseThrow(() -> new ResourceNotFoundException("Product %s not found".formatted(productCode)));
    }
}
