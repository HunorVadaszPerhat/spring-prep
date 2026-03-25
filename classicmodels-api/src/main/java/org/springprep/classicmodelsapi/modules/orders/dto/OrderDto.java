package org.springprep.classicmodelsapi.modules.orders.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record OrderDto(
        Integer orderNumber,
        @NotNull
        LocalDate orderDate,
        @NotNull
        LocalDate requiredDate,
        LocalDate shippedDate,
        @NotBlank @Size(max = 15)
        String status,
        String comments,
        @NotNull
        Integer customerNumber
) {
}
