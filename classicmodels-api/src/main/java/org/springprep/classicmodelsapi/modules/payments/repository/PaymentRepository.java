package org.springprep.classicmodelsapi.modules.payments.repository;

import org.springprep.classicmodelsapi.modules.payments.model.Payment;
import org.springprep.classicmodelsapi.modules.payments.model.PaymentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {
}
