package org.decouplingprofiles;

import org.springframework.stereotype.Service;

/**
 * A decoupled service demonstrating implementation-agnostic code.
 * OrderService depends on the interface and remains byte-for-byte identical.
 */
@Service
public class OrderService {

    private final Notifier notifier;

    /**
     * Spring injects the active Notifier implementation.
     * OrderService never specifies EmailNotifier or SmsNotifier.
     */
    public OrderService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void placeOrder(Order o) {
        System.out.println("--- Placing order in OrderService ---");
        // We call the 'send' method on whichever Notifier Spring injected.
        notifier.send(o);
    }
}
