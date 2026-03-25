package org.springprep.classicmodelsapi.modules.products.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springprep.classicmodelsapi.infrastructure.exception.ResourceNotFoundException;
import org.springprep.classicmodelsapi.modules.productlines.model.ProductLine;
import org.springprep.classicmodelsapi.modules.productlines.repository.ProductLineRepository;
import org.springprep.classicmodelsapi.modules.products.dto.ProductDto;
import org.springprep.classicmodelsapi.modules.products.mapper.ProductMapper;
import org.springprep.classicmodelsapi.modules.products.model.Product;
import org.springprep.classicmodelsapi.modules.products.repository.ProductRepository;
import org.springprep.classicmodelsapi.modules.products.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductLineRepository productLineRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    @Override
    public ProductDto findById(String productCode) {
        return productMapper.toDto(getProduct(productCode));
    }

    @Override
    @Transactional
    public ProductDto create(ProductDto dto) {
        Product product = productMapper.toEntity(dto);
        product.setProductLine(getProductLine(dto.productLine()));
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    @Transactional
    public ProductDto update(String productCode, ProductDto dto) {
        Product existing = getProduct(productCode);
        existing.setProductName(dto.productName());
        existing.setProductScale(dto.productScale());
        existing.setProductVendor(dto.productVendor());
        existing.setProductDescription(dto.productDescription());
        existing.setQuantityInStock(dto.quantityInStock());
        existing.setBuyPrice(dto.buyPrice());
        existing.setMsrp(dto.msrp());
        existing.setProductLine(getProductLine(dto.productLine()));
        return productMapper.toDto(existing);
    }

    @Override
    @Transactional
    public void delete(String productCode) {
        productRepository.delete(getProduct(productCode));
    }

    private Product getProduct(String productCode) {
        return productRepository.findById(productCode)
                .orElseThrow(() -> new ResourceNotFoundException("Product %s not found".formatted(productCode)));
    }

    private ProductLine getProductLine(String productLine) {
        return productLineRepository.findById(productLine)
                .orElseThrow(() -> new ResourceNotFoundException("Product line %s not found".formatted(productLine)));
    }
}
