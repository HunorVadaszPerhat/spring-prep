package org.springprep.classicmodelsapi.modules.customers.service;

import org.springprep.classicmodelsapi.modules.customers.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> findAll();

    CustomerDto findById(Integer customerNumber);

    CustomerDto create(CustomerDto dto);

    CustomerDto update(Integer customerNumber, CustomerDto dto);

    void delete(Integer customerNumber);
}
