package org.decouplingprofiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * An EMAIL-based implementation of the Notifier contract.
 * By using @Profile, we tell Spring this bean is active only for specific profiles.
 * It's common to make the "real" or "prod" implementation the primary or default.
 */
@Component
@Profile("prod") // OR @Profile("default") OR omit to have it always active until another profile overrules it.
public class EmailNotifier implements Notifier {
    @Override
    public void send(Order o) {
        System.out.println(">>> Sending an EMAIL notification for Order " + o.getId() + ": " + o.getDescription());
    }
}
