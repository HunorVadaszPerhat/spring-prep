package org.springprep.classicmodelsapi.modules.orderdetails.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrderDetailDto(
        @NotNull
        Integer orderNumber,
        @NotBlank
        String productCode,
        @NotNull
        Integer quantityOrdered,
        @NotNull @Digits(integer = 8, fraction = 2)
        BigDecimal priceEach,
        @NotNull
        Short orderLineNumber
) {
}
