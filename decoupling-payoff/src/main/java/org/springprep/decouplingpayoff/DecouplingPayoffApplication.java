package org.springprep.decouplingpayoff;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DecouplingPayoffApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecouplingPayoffApplication.class, args);
    }

    /**
     * A runner that executes after the Spring application context has loaded.
     * It demonstrates that the OrderService is correctly wired with the active implementation.
     */
    @Bean
    public CommandLineRunner runner(OrderService service) {
        return args -> {
            System.out.println("\n--- Decoupled Profile Demo Runner ---");
            Order testOrder = new Order("A123", "Widget order from profile demo");
            // The service is decoupled; it will use whichever active Notifier Spring injected.
            service.placeOrder(testOrder);
            System.out.println("-------------------------------------\n");
        };
    }

}
