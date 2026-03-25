package org.springprep.classicmodelsapi.modules.orders.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springprep.classicmodelsapi.modules.orders.dto.OrderDto;
import org.springprep.classicmodelsapi.modules.orders.model.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderNumber", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "orderDetails", ignore = true)
    Order toEntity(OrderDto dto);

    @Mapping(target = "customerNumber", source = "customer.customerNumber")
    OrderDto toDto(Order entity);
}
