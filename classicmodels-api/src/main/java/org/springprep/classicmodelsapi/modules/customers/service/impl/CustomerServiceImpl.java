package org.springprep.classicmodelsapi.modules.customers.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springprep.classicmodelsapi.infrastructure.exception.ResourceNotFoundException;
import org.springprep.classicmodelsapi.modules.customers.dto.CustomerDto;
import org.springprep.classicmodelsapi.modules.customers.mapper.CustomerMapper;
import org.springprep.classicmodelsapi.modules.customers.model.Customer;
import org.springprep.classicmodelsapi.modules.customers.repository.CustomerRepository;
import org.springprep.classicmodelsapi.modules.customers.service.CustomerService;
import org.springprep.classicmodelsapi.modules.employees.model.Employee;
import org.springprep.classicmodelsapi.modules.employees.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream().map(customerMapper::toDto).toList();
    }

    @Override
    public CustomerDto findById(Integer customerNumber) {
        return customerMapper.toDto(getCustomer(customerNumber));
    }

    @Override
    @Transactional
    public CustomerDto create(CustomerDto dto) {
        Customer customer = customerMapper.toEntity(dto);
        customer.setSalesRepresentative(resolveSalesRep(dto.salesRepEmployeeNumber()));
        return customerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    @Transactional
    public CustomerDto update(Integer customerNumber, CustomerDto dto) {
        Customer existing = getCustomer(customerNumber);
        existing.setCustomerName(dto.customerName());
        existing.setContactLastName(dto.contactLastName());
        existing.setContactFirstName(dto.contactFirstName());
        existing.setPhone(dto.phone());
        existing.setAddressLine1(dto.addressLine1());
        existing.setAddressLine2(dto.addressLine2());
        existing.setCity(dto.city());
        existing.setState(dto.state());
        existing.setPostalCode(dto.postalCode());
        existing.setCountry(dto.country());
        existing.setSalesRepresentative(resolveSalesRep(dto.salesRepEmployeeNumber()));
        existing.setCreditLimit(dto.creditLimit());
        return customerMapper.toDto(existing);
    }

    @Override
    @Transactional
    public void delete(Integer customerNumber) {
        customerRepository.delete(getCustomer(customerNumber));
    }

    private Customer getCustomer(Integer customerNumber) {
        return customerRepository.findById(customerNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer %d not found".formatted(customerNumber)));
    }

    private Employee resolveSalesRep(Integer employeeNumber) {
        if (employeeNumber == null) {
            return null;
        }
        return employeeRepository.findById(employeeNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Employee %d not found".formatted(employeeNumber)));
    }
}
