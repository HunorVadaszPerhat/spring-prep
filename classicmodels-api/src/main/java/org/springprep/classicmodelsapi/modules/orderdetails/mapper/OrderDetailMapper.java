package org.springprep.classicmodelsapi.modules.orderdetails.mapper;

import org.mapstruct.Mapper;
import org.springprep.classicmodelsapi.modules.orderdetails.dto.OrderDetailDto;
import org.springprep.classicmodelsapi.modules.orderdetails.model.OrderDetail;
import org.springprep.classicmodelsapi.modules.orderdetails.model.OrderDetailId;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

    default OrderDetail toEntity(OrderDetailDto dto) {
        if (dto == null) {
            return null;
        }
        return OrderDetail.builder()
                .id(new OrderDetailId(dto.orderNumber(), dto.productCode()))
                .quantityOrdered(dto.quantityOrdered())
                .priceEach(dto.priceEach())
                .orderLineNumber(dto.orderLineNumber())
                .build();
    }

    default OrderDetailDto toDto(OrderDetail entity) {
        if (entity == null || entity.getId() == null) {
            return null;
        }
        return new OrderDetailDto(
                entity.getId().getOrderNumber(),
                entity.getId().getProductCode(),
                entity.getQuantityOrdered(),
                entity.getPriceEach(),
                entity.getOrderLineNumber()
        );
    }
}
