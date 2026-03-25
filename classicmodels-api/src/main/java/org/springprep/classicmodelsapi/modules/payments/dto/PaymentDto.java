package org.springprep.classicmodelsapi.modules.payments.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentDto(
        @NotNull
        Integer customerNumber,
        @NotBlank
        String checkNumber,
        @NotNull
        LocalDate paymentDate,
        @NotNull @Digits(integer = 8, fraction = 2)
        BigDecimal amount
) {
}
