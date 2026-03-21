package org.decouplingdependsoninterface;

import org.springframework.stereotype.Service;

/**
 * A decoupled service demonstrating Constructor Injection.
 * Decoupling is achieved when OrderService declares Notifier as its dependency.
 * It never imports EmailNotifier or SmsNotifier directly.
 */
@Service
public class OrderService {

    // Interface type - not a concrete class.
    // Making it final ensures it's set once, typically via the constructor.
    private final Notifier notifier;

    /**
     * Spring injects the right implementation at startup.
     * The single constructor is implicitly used for injection in modern Spring.
     * OrderService has zero imports of EmailNotifier or SmsNotifier.
     */
    public OrderService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void placeOrder(Order o) {
        System.out.println("--- Placing order in Decoupled OrderService ---");
        // Polymorphic call - OrderService doesn't care which impl is used.
        // There is no explicit 'new' concrete class creation.
        notifier.send(o);
    }
}
