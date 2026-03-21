package org.decouplingproblem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DecouplingProblemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecouplingProblemApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(OrderService service) {
        return args -> {
            Order testOrder = new Order("A123", "Example item from a tightly coupled service");
            // The service is hard-wired and will always send an email.
            service.placeOrder(testOrder);
        };
    }

}
