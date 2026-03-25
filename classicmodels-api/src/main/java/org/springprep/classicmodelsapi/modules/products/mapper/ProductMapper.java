package org.springprep.classicmodelsapi.modules.products.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springprep.classicmodelsapi.modules.products.dto.ProductDto;
import org.springprep.classicmodelsapi.modules.products.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "productLine", ignore = true)
    @Mapping(target = "orderDetails", ignore = true)
    Product toEntity(ProductDto dto);

    @Mapping(target = "productLine", source = "productLine.productLine")
    ProductDto toDto(Product entity);
}
