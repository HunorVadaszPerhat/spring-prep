package org.springprep.classicmodelsapi.modules.payments.mapper;

import org.mapstruct.Mapper;
import org.springprep.classicmodelsapi.modules.payments.dto.PaymentDto;
import org.springprep.classicmodelsapi.modules.payments.model.Payment;
import org.springprep.classicmodelsapi.modules.payments.model.PaymentId;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    default Payment toEntity(PaymentDto dto) {
        if (dto == null) {
            return null;
        }
        return Payment.builder()
                .id(new PaymentId(dto.customerNumber(), dto.checkNumber()))
                .paymentDate(dto.paymentDate())
                .amount(dto.amount())
                .build();
    }

    default PaymentDto toDto(Payment entity) {
        if (entity == null || entity.getId() == null) {
            return null;
        }
        return new PaymentDto(
                entity.getId().getCustomerNumber(),
                entity.getId().getCheckNumber(),
                entity.getPaymentDate(),
                entity.getAmount()
        );
    }
}
