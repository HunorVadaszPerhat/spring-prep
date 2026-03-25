package org.springprep.classicmodelsapi.modules.customers.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springprep.classicmodelsapi.modules.customers.dto.CustomerDto;
import org.springprep.classicmodelsapi.modules.customers.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "customerNumber", ignore = true)
    @Mapping(target = "salesRepresentative", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "payments", ignore = true)
    Customer toEntity(CustomerDto dto);

    @Mapping(target = "salesRepEmployeeNumber", source = "salesRepresentative.employeeNumber")
    CustomerDto toDto(Customer entity);
}
