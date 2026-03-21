package org.springprep.__1ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* The OrderService demonstrates the various ways Spring can "push" dependencies into a class.
* */
@Service
public class OrderService {

    // 1. FIELD INJECTION (Anti-pattern)
    // Problem: Hard to unit test (requires reflection), field cannot be final.
    @Autowired
    private PaymentGateway fieldInjectedGateway;

    private PaymentGateway setterInjectedGateway;
    private final PaymentGateway constructorInjectedGateway;

    // 2. CONSTRUCTOR INJECTION (Preferred)
    // Benefit: Field can be 'final', guarantees non-null, works with plain 'new' in tests.
    // Note: @Autowired is optional here since Spring 4.3+ for single constructors.
    public OrderService(PaymentGateway paymentGateway) {
        this.constructorInjectedGateway = paymentGateway;
    }

    // 3. SETTER INJECTION (Use for optional dependencies)
    @Autowired
    public void setSetterInjectedGateway(PaymentGateway paymentGateway) {
        this.setterInjectedGateway = paymentGateway;
    }

    public void completeOrder(double amount) {
        System.out.println("Using Constructor Injection:");
        constructorInjectedGateway.process(amount);
    }
}
