package org.springprep.classicmodelsapi.modules.customers.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springprep.classicmodelsapi.modules.customers.dto.CustomerDto;
import org.springprep.classicmodelsapi.modules.customers.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{customerNumber}")
    public CustomerDto getCustomer(@PathVariable Integer customerNumber) {
        return customerService.findById(customerNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@Valid @RequestBody CustomerDto dto) {
        return customerService.create(dto);
    }

    @PutMapping("/{customerNumber}")
    public CustomerDto updateCustomer(@PathVariable Integer customerNumber, @Valid @RequestBody CustomerDto dto) {
        return customerService.update(customerNumber, dto);
    }

    @DeleteMapping("/{customerNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer customerNumber) {
        customerService.delete(customerNumber);
    }
}
