package org.springprep.classicmodelsapi.modules.orderdetails.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springprep.classicmodelsapi.modules.orderdetails.dto.OrderDetailDto;
import org.springprep.classicmodelsapi.modules.orderdetails.service.OrderDetailService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-details")
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @GetMapping
    public List<OrderDetailDto> getOrderDetails() {
        return orderDetailService.findAll();
    }

    @GetMapping("/{orderNumber}/{productCode}")
    public OrderDetailDto getOrderDetail(@PathVariable Integer orderNumber, @PathVariable String productCode) {
        return orderDetailService.findById(orderNumber, productCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDetailDto createOrderDetail(@Valid @RequestBody OrderDetailDto dto) {
        return orderDetailService.create(dto);
    }

    @PutMapping("/{orderNumber}/{productCode}")
    public OrderDetailDto updateOrderDetail(@PathVariable Integer orderNumber,
                                            @PathVariable String productCode,
                                            @Valid @RequestBody OrderDetailDto dto) {
        return orderDetailService.update(orderNumber, productCode, dto);
    }

    @DeleteMapping("/{orderNumber}/{productCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderDetail(@PathVariable Integer orderNumber, @PathVariable String productCode) {
        orderDetailService.delete(orderNumber, productCode);
    }
}
