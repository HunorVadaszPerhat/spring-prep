package org.decouplingdependsoninterface;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DecouplingDependsOnInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecouplingDependsOnInterfaceApplication.class, args);
    }

    /**
     * A runner that executes after the Spring application context has loaded.
     * It demonstrates that the OrderService is correctly wired.
     */
    @Bean
    public CommandLineRunner runner(OrderService service) {
        return args -> {
            System.out.println("\n--- Decoupled OrderService Runner ---");
            Order testOrder = new Order("A123", "Widget order from decoupled service");
            // The service is decoupled; it will use whichever Notifier Spring injected.
            service.placeOrder(testOrder);
            System.out.println("-------------------------------------\n");
        };
    }

}
