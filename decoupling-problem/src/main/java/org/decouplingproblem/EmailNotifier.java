package org.decouplingproblem;

import org.springframework.stereotype.Component;

// A concrete implementation of a notification mechanism.
@Component // Not actually needed yet as OrderService does its own "new", but standard
public class EmailNotifier {

    public void send(Order o) {
        System.out.println(">>> Sending an EMAIL notification for Order " + o.getId() + ": " + o.getDescription());
    }
}
