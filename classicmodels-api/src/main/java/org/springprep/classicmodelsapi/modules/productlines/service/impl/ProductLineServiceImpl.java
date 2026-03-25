package org.springprep.classicmodelsapi.modules.productlines.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springprep.classicmodelsapi.infrastructure.exception.ResourceNotFoundException;
import org.springprep.classicmodelsapi.modules.productlines.dto.ProductLineDto;
import org.springprep.classicmodelsapi.modules.productlines.mapper.ProductLineMapper;
import org.springprep.classicmodelsapi.modules.productlines.model.ProductLine;
import org.springprep.classicmodelsapi.modules.productlines.repository.ProductLineRepository;
import org.springprep.classicmodelsapi.modules.productlines.service.ProductLineService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductLineServiceImpl implements ProductLineService {

    private final ProductLineRepository productLineRepository;
    private final ProductLineMapper productLineMapper;

    @Override
    public List<ProductLineDto> findAll() {
        return productLineRepository.findAll().stream().map(productLineMapper::toDto).toList();
    }

    @Override
    public ProductLineDto findById(String productLine) {
        return productLineMapper.toDto(getProductLine(productLine));
    }

    @Override
    @Transactional
    public ProductLineDto create(ProductLineDto dto) {
        ProductLine entity = productLineMapper.toEntity(dto);
        return productLineMapper.toDto(productLineRepository.save(entity));
    }

    @Override
    @Transactional
    public ProductLineDto update(String productLine, ProductLineDto dto) {
        ProductLine existing = getProductLine(productLine);
        existing.setTextDescription(dto.textDescription());
        existing.setHtmlDescription(dto.htmlDescription());
        existing.setImage(dto.image());
        return productLineMapper.toDto(existing);
    }

    @Override
    @Transactional
    public void delete(String productLine) {
        productLineRepository.delete(getProductLine(productLine));
    }

    private ProductLine getProductLine(String productLine) {
        return productLineRepository.findById(productLine)
                .orElseThrow(() -> new ResourceNotFoundException("Product line %s not found".formatted(productLine)));
    }
}
