package org.decouplinginterface;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DecouplingInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecouplingInterfaceApplication.class, args);
    }

    /**
     * A runner that executes after the Spring application context has loaded.
     * It demonstrates that we have two unique, competing implementations.
     * For this simple demonstration, we inject the concrete classes directly to
     * verify their individual existence as managed beans.
     */
    @Bean
    public CommandLineRunner runner(EmailNotifier emailNotifier, SmsNotifier smsNotifier) {
        return args -> {
            System.out.println("\n--- Interface and Implementation Demo Runner ---");

            // We have a concrete contract (Notifier) and multiple managed implementations.
            Order testOrder = new Order("A123", "Standard Widget order");

            System.out.println("Demonstrating competing implementation behavior:");
            // Demonstrate Email behavior
            emailNotifier.send(testOrder);
            // Demonstrate SMS behavior
            smsNotifier.send(testOrder);

            System.out.println("-----------------------------------------------\n");
        };
    }


}
