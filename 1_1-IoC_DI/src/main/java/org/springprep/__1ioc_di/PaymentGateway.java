package org.springprep.__1ioc_di;

/*
* To achieve decoupling, we define an interface.
* The OrderService will depend on this interface, not a specific implementation.
* */
public interface PaymentGateway {
    void process(double amount);
}
