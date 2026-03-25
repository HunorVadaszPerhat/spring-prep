package org.springprep.classicmodelsapi.modules.employees.service;

import org.springprep.classicmodelsapi.modules.employees.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> findAll();

    EmployeeDto findById(Integer employeeNumber);

    EmployeeDto create(EmployeeDto dto);

    EmployeeDto update(Integer employeeNumber, EmployeeDto dto);

    void delete(Integer employeeNumber);
}
