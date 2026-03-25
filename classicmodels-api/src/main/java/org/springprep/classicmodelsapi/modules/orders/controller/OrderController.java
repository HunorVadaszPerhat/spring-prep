package org.springprep.classicmodelsapi.modules.orders.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springprep.classicmodelsapi.modules.orders.dto.OrderDto;
import org.springprep.classicmodelsapi.modules.orders.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> getOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{orderNumber}")
    public OrderDto getOrder(@PathVariable Integer orderNumber) {
        return orderService.findById(orderNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@Valid @RequestBody OrderDto dto) {
        return orderService.create(dto);
    }

    @PutMapping("/{orderNumber}")
    public OrderDto updateOrder(@PathVariable Integer orderNumber, @Valid @RequestBody OrderDto dto) {
        return orderService.update(orderNumber, dto);
    }

    @DeleteMapping("/{orderNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Integer orderNumber) {
        orderService.delete(orderNumber);
    }
}
