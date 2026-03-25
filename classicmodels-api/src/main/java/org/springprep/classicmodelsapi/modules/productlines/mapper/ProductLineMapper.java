package org.springprep.classicmodelsapi.modules.productlines.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springprep.classicmodelsapi.modules.productlines.dto.ProductLineDto;
import org.springprep.classicmodelsapi.modules.productlines.model.ProductLine;

@Mapper(componentModel = "spring")
public interface ProductLineMapper {

    @Mapping(target = "products", ignore = true)
    ProductLine toEntity(ProductLineDto dto);

    ProductLineDto toDto(ProductLine entity);
}
