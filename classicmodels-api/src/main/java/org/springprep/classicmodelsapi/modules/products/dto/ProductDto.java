package org.springprep.classicmodelsapi.modules.products.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductDto(
        @NotBlank @Size(max = 15)
        String productCode,
        @NotBlank @Size(max = 70)
        String productName,
        @NotBlank
        String productLine,
        @NotBlank @Size(max = 10)
        String productScale,
        @NotBlank @Size(max = 50)
        String productVendor,
        @NotBlank
        String productDescription,
        @NotNull
        Integer quantityInStock,
        @NotNull @Digits(integer = 8, fraction = 2)
        BigDecimal buyPrice,
        @NotNull @Digits(integer = 8, fraction = 2)
        BigDecimal msrp
) {
}
