package org.springprep.classicmodelsapi.modules.employees.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeDto(
        Integer employeeNumber,
        @NotBlank @Size(max = 50)
        String lastName,
        @NotBlank @Size(max = 50)
        String firstName,
        @NotBlank @Size(max = 10)
        String extension,
        @Email @NotBlank
        String email,
        @NotBlank
        String officeCode,
        Integer reportsTo,
        @NotBlank @Size(max = 50)
        String jobTitle
) {
}
