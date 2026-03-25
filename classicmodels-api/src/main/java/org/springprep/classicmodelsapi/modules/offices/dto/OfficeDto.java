package org.springprep.classicmodelsapi.modules.offices.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OfficeDto(
        @NotBlank(message = "Office code is required")
        @Size(max = 10)
        String officeCode,
        @NotBlank @Size(max = 50)
        String city,
        @NotBlank @Size(max = 50)
        String phone,
        @NotBlank @Size(max = 50)
        String addressLine1,
        @Size(max = 50)
        String addressLine2,
        @Size(max = 50)
        String state,
        @NotBlank @Size(max = 50)
        String country,
        @NotBlank @Size(max = 15)
        String postalCode,
        @NotBlank @Size(max = 10)
        String territory
) {
}
