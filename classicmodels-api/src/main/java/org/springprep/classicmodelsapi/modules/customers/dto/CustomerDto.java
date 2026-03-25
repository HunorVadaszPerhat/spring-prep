package org.springprep.classicmodelsapi.modules.customers.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CustomerDto(
        Integer customerNumber,
        @NotBlank @Size(max = 50)
        String customerName,
        @NotBlank @Size(max = 50)
        String contactLastName,
        @NotBlank @Size(max = 50)
        String contactFirstName,
        @NotBlank @Size(max = 50)
        String phone,
        @NotBlank @Size(max = 50)
        String addressLine1,
        @Size(max = 50)
        String addressLine2,
        @NotBlank @Size(max = 50)
        String city,
        @Size(max = 50)
        String state,
        @Size(max = 15)
        String postalCode,
        @NotBlank @Size(max = 50)
        String country,
        Integer salesRepEmployeeNumber,
        @Digits(integer = 8, fraction = 2)
        BigDecimal creditLimit
) {
}
