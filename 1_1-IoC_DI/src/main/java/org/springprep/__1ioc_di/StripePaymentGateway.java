package org.springprep.__1ioc_di;

import org.springframework.stereotype.Component;

/*
* We mark concrete implementations with @Component so the Spring IoC Container can manage their lifecycle.
* */
@Component
public class StripePaymentGateway implements PaymentGateway {
    @Override
    public void process(double amount) {
        System.out.println("Processing $" + amount + " via Stripe.");
    }
}
