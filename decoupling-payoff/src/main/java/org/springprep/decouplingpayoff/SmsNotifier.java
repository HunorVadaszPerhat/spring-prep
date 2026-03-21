package org.springprep.decouplingpayoff;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * An SMS-based implementation of the Notifier contract.
 * This bean is active ONLY when the "sms" profile is enabled.
 */
@Component
@Profile("sms")
public class SmsNotifier implements Notifier {
    @Override
    public void send(Order o) {
        System.out.println(">>> Sending an SMS notification for Order " + o.getId() + ": " + o.getDescription());
    }
}
