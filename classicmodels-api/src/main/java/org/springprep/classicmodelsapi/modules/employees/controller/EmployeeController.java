package org.springprep.classicmodelsapi.modules.employees.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springprep.classicmodelsapi.modules.employees.dto.EmployeeDto;
import org.springprep.classicmodelsapi.modules.employees.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeNumber}")
    public EmployeeDto getEmployee(@PathVariable Integer employeeNumber) {
        return employeeService.findById(employeeNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto dto) {
        return employeeService.create(dto);
    }

    @PutMapping("/{employeeNumber}")
    public EmployeeDto updateEmployee(@PathVariable Integer employeeNumber, @Valid @RequestBody EmployeeDto dto) {
        return employeeService.update(employeeNumber, dto);
    }

    @DeleteMapping("/{employeeNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Integer employeeNumber) {
        employeeService.delete(employeeNumber);
    }
}
