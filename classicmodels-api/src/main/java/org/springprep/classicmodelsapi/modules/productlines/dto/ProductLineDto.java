package org.springprep.classicmodelsapi.modules.productlines.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductLineDto(
        @NotBlank @Size(max = 50)
        String productLine,
        @Size(max = 4000)
        String textDescription,
        String htmlDescription,
        byte[] image
) {
}
