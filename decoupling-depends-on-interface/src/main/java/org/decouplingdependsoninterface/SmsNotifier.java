package org.decouplingdependsoninterface;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Another concrete managed Spring bean implementing the Notifier contract.
 */
@Component
public class SmsNotifier implements Notifier {
    @Override
    public void send(Order o) {
        System.out.println(">>> Sending an SMS notification for Order " + o.getId() + ": " + o.getDescription());
    }
}
