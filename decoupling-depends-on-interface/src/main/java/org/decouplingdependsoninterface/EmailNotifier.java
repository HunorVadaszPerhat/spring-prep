package org.decouplingdependsoninterface;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * A concrete managed Spring bean implementing the Notifier contract.
 */
@Component
@Primary
public class EmailNotifier implements Notifier {
    @Override
    public void send(Order o) {
        System.out.println(">>> Sending an EMAIL notification for Order " + o.getId() + ": " + o.getDescription());
    }
}
