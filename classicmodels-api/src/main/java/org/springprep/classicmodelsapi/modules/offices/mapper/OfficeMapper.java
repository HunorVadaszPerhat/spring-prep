package org.springprep.classicmodelsapi.modules.offices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springprep.classicmodelsapi.modules.offices.dto.OfficeDto;
import org.springprep.classicmodelsapi.modules.offices.model.Office;

@Mapper(componentModel = "spring")
public interface OfficeMapper {

    @Mapping(target = "employees", ignore = true)
    Office toEntity(OfficeDto dto);

    OfficeDto toDto(Office entity);
}
