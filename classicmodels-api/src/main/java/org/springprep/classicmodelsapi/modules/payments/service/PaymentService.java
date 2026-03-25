package org.springprep.classicmodelsapi.modules.payments.service;

import org.springprep.classicmodelsapi.modules.payments.dto.PaymentDto;

import java.util.List;

public interface PaymentService {

    List<PaymentDto> findAll();

    PaymentDto findById(Integer customerNumber, String checkNumber);

    PaymentDto create(PaymentDto dto);

    PaymentDto update(Integer customerNumber, String checkNumber, PaymentDto dto);

    void delete(Integer customerNumber, String checkNumber);
}
