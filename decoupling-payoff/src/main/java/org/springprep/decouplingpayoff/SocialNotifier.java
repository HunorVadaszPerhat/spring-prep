package org.springprep.decouplingpayoff;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("social")
public class SocialNotifier implements Notifier {
    @Override
    public void send(Order o) {
        System.out.println("Sending a social notification for Order " + o.getId() + ": " + o.getDescription()
        );
    }
}
