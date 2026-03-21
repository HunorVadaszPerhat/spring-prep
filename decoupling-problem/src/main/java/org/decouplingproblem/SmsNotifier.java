package org.decouplingproblem;

import org.springframework.stereotype.Component;

// Another potential concrete implementation.
@Component
public class SmsNotifier {
    // In the tightly coupled state, this class is UNREACHABLE and unused.
    public void send(Order o) {
        System.out.println(">>> Sending an SMS notification for Order " + o.getId() + ": " + o.getDescription());
    }
}
