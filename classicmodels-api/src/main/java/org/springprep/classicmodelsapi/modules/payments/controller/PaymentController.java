package org.springprep.classicmodelsapi.modules.payments.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springprep.classicmodelsapi.modules.payments.dto.PaymentDto;
import org.springprep.classicmodelsapi.modules.payments.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentDto> getPayments() {
        return paymentService.findAll();
    }

    @GetMapping("/{customerNumber}/{checkNumber}")
    public PaymentDto getPayment(@PathVariable Integer customerNumber, @PathVariable String checkNumber) {
        return paymentService.findById(customerNumber, checkNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDto createPayment(@Valid @RequestBody PaymentDto dto) {
        return paymentService.create(dto);
    }

    @PutMapping("/{customerNumber}/{checkNumber}")
    public PaymentDto updatePayment(@PathVariable Integer customerNumber,
                                    @PathVariable String checkNumber,
                                    @Valid @RequestBody PaymentDto dto) {
        return paymentService.update(customerNumber, checkNumber, dto);
    }

    @DeleteMapping("/{customerNumber}/{checkNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePayment(@PathVariable Integer customerNumber, @PathVariable String checkNumber) {
        paymentService.delete(customerNumber, checkNumber);
    }
}
