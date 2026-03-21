package org.decouplinginterface;

import org.springframework.stereotype.Component;

/**
 * The second competing implementation of the Notifier contract.
 * Like EmailNotifier, this is also a managed Spring bean.
 */
@Component
public class SmsNotifier implements Notifier {
    @Override
    public void send(Order o) {
        // /* sms */
        System.out.println(">>> Sending an SMS notification for Order " + o.getId() + " - Description: " + o.getDescription());
    }
}
