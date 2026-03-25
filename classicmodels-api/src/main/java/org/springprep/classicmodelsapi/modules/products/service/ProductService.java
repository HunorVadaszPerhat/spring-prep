package org.springprep.classicmodelsapi.modules.products.service;

import org.springprep.classicmodelsapi.modules.products.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(String productCode);

    ProductDto create(ProductDto dto);

    ProductDto update(String productCode, ProductDto dto);

    void delete(String productCode);
}
