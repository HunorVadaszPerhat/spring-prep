package org.decouplingproblem;

import org.springframework.stereotype.Service;

// The central service, but in a tightly coupled "bad" state.
@Service
public class OrderService {

    // --- Tight Coupling Problem Area ---
    // Error: OrderService decides which concrete class to use.
    // Concrete type is hard-wired here.
    private final EmailNotifier notifier = new EmailNotifier();
    // ------------------------------------

    public void placeOrder(Order o) {
        System.out.println("\n--- Placing order in Tightly Coupled OrderService ---");
        // Always uses the email notifier - there is no choice or flexibility.
        notifier.send(o);
    }
}
