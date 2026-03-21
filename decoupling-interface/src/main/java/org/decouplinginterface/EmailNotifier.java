package org.decouplinginterface;

import org.springframework.stereotype.Component;

/**
 * The first competing implementation of the Notifier contract.
 * By adding @Component, we tell Spring to manage this class as a 'bean'.
 */
@Component
public class EmailNotifier implements Notifier {
    @Override
    public void send(Order o) {
        // /* email */
        System.out.println(">>> Sending an EMAIL notification for Order " + o.getId() + " - Description: " + o.getDescription());
    }
}
