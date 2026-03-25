package org.springprep.classicmodelsapi.modules.productlines.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springprep.classicmodelsapi.modules.productlines.dto.ProductLineDto;
import org.springprep.classicmodelsapi.modules.productlines.service.ProductLineService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-lines")
@RequiredArgsConstructor
public class ProductLineController {

    private final ProductLineService productLineService;

    @GetMapping
    public List<ProductLineDto> getProductLines() {
        return productLineService.findAll();
    }

    @GetMapping("/{productLine}")
    public ProductLineDto getProductLine(@PathVariable String productLine) {
        return productLineService.findById(productLine);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductLineDto createProductLine(@Valid @RequestBody ProductLineDto dto) {
        return productLineService.create(dto);
    }

    @PutMapping("/{productLine}")
    public ProductLineDto updateProductLine(@PathVariable String productLine, @Valid @RequestBody ProductLineDto dto) {
        return productLineService.update(productLine, dto);
    }

    @DeleteMapping("/{productLine}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductLine(@PathVariable String productLine) {
        productLineService.delete(productLine);
    }
}
