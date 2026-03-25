package org.springprep.classicmodelsapi.modules.payments.model;

import jakarta.persistence.*;
import lombok.*;
import org.springprep.classicmodelsapi.modules.customers.model.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @EmbeddedId
    private PaymentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("customerNumber")
    @JoinColumn(name = "customerNumber")
    private Customer customer;

    @Column(name = "paymentDate", nullable = false)
    private LocalDate paymentDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
}
