package org.springprep.classicmodelsapi.modules.employees.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springprep.classicmodelsapi.infrastructure.exception.ResourceNotFoundException;
import org.springprep.classicmodelsapi.modules.employees.dto.EmployeeDto;
import org.springprep.classicmodelsapi.modules.employees.mapper.EmployeeMapper;
import org.springprep.classicmodelsapi.modules.employees.model.Employee;
import org.springprep.classicmodelsapi.modules.employees.repository.EmployeeRepository;
import org.springprep.classicmodelsapi.modules.employees.service.EmployeeService;
import org.springprep.classicmodelsapi.modules.offices.model.Office;
import org.springprep.classicmodelsapi.modules.offices.repository.OfficeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDto).toList();
    }

    @Override
    public EmployeeDto findById(Integer employeeNumber) {
        return employeeMapper.toDto(getEmployee(employeeNumber));
    }

    @Override
    @Transactional
    public EmployeeDto create(EmployeeDto dto) {
        Employee employee = employeeMapper.toEntity(dto);
        employee.setOffice(getOffice(dto.officeCode()));
        employee.setManager(dto.reportsTo() != null ? getEmployee(dto.reportsTo()) : null);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    @Transactional
    public EmployeeDto update(Integer employeeNumber, EmployeeDto dto) {
        Employee existing = getEmployee(employeeNumber);
        existing.setLastName(dto.lastName());
        existing.setFirstName(dto.firstName());
        existing.setExtension(dto.extension());
        existing.setEmail(dto.email());
        existing.setJobTitle(dto.jobTitle());
        existing.setOffice(getOffice(dto.officeCode()));
        existing.setManager(dto.reportsTo() != null ? getEmployee(dto.reportsTo()) : null);
        return employeeMapper.toDto(existing);
    }

    @Override
    @Transactional
    public void delete(Integer employeeNumber) {
        Employee existing = getEmployee(employeeNumber);
        employeeRepository.delete(existing);
    }

    private Employee getEmployee(Integer employeeNumber) {
        return employeeRepository.findById(employeeNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Employee %d not found".formatted(employeeNumber)));
    }

    private Office getOffice(String officeCode) {
        return officeRepository.findById(officeCode)
                .orElseThrow(() -> new ResourceNotFoundException("Office %s not found".formatted(officeCode)));
    }
}
