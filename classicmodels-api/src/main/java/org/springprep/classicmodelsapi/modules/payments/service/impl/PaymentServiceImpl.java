package org.springprep.classicmodelsapi.modules.payments.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springprep.classicmodelsapi.infrastructure.exception.ResourceNotFoundException;
import org.springprep.classicmodelsapi.modules.customers.model.Customer;
import org.springprep.classicmodelsapi.modules.customers.repository.CustomerRepository;
import org.springprep.classicmodelsapi.modules.payments.dto.PaymentDto;
import org.springprep.classicmodelsapi.modules.payments.mapper.PaymentMapper;
import org.springprep.classicmodelsapi.modules.payments.model.Payment;
import org.springprep.classicmodelsapi.modules.payments.model.PaymentId;
import org.springprep.classicmodelsapi.modules.payments.repository.PaymentRepository;
import org.springprep.classicmodelsapi.modules.payments.service.PaymentService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public List<PaymentDto> findAll() {
        return paymentRepository.findAll().stream().map(paymentMapper::toDto).toList();
    }

    @Override
    public PaymentDto findById(Integer customerNumber, String checkNumber) {
        return paymentMapper.toDto(getPayment(customerNumber, checkNumber));
    }

    @Override
    @Transactional
    public PaymentDto create(PaymentDto dto) {
        Payment payment = paymentMapper.toEntity(dto);
        payment.setCustomer(getCustomer(dto.customerNumber()));
        return paymentMapper.toDto(paymentRepository.save(payment));
    }

    @Override
    @Transactional
    public PaymentDto update(Integer customerNumber, String checkNumber, PaymentDto dto) {
        Payment existing = getPayment(customerNumber, checkNumber);
        if (!customerNumber.equals(dto.customerNumber()) || !checkNumber.equals(dto.checkNumber())) {
            throw new IllegalArgumentException("Payment key cannot be changed during update");
        }
        existing.setPaymentDate(dto.paymentDate());
        existing.setAmount(dto.amount());
        existing.setCustomer(getCustomer(customerNumber));
        return paymentMapper.toDto(paymentRepository.save(existing));
    }

    @Override
    @Transactional
    public void delete(Integer customerNumber, String checkNumber) {
        paymentRepository.delete(getPayment(customerNumber, checkNumber));
    }

    private Payment getPayment(Integer customerNumber, String checkNumber) {
        return paymentRepository.findById(new PaymentId(customerNumber, checkNumber))
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Payment %d/%s not found".formatted(customerNumber, checkNumber)));
    }

    private Customer getCustomer(Integer customerNumber) {
        return customerRepository.findById(customerNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer %d not found".formatted(customerNumber)));
    }
}
