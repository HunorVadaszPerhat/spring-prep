package org.springprep.classicmodelsapi.modules.productlines.service;

import org.springprep.classicmodelsapi.modules.productlines.dto.ProductLineDto;

import java.util.List;

public interface ProductLineService {

    List<ProductLineDto> findAll();

    ProductLineDto findById(String productLine);

    ProductLineDto create(ProductLineDto dto);

    ProductLineDto update(String productLine, ProductLineDto dto);

    void delete(String productLine);
}
