package org.springprep.classicmodelsapi.modules.products.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springprep.classicmodelsapi.modules.products.dto.ProductDto;
import org.springprep.classicmodelsapi.modules.products.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/{productCode}")
    public ProductDto getProduct(@PathVariable String productCode) {
        return productService.findById(productCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@Valid @RequestBody ProductDto dto) {
        return productService.create(dto);
    }

    @PutMapping("/{productCode}")
    public ProductDto updateProduct(@PathVariable String productCode, @Valid @RequestBody ProductDto dto) {
        return productService.update(productCode, dto);
    }

    @DeleteMapping("/{productCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String productCode) {
        productService.delete(productCode);
    }
}
