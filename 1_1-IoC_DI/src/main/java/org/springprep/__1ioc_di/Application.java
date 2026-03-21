package org.springprep.__1ioc_di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    /*
    * This main class demonstrates how the ApplicationContext acts as the "Manager" of the system,
    * and why we avoid Dependency Lookup.
    * */
    public static void main(String[] args) {
        // The ApplicationContext is the high-level IoC Container.
        // It provides AOP, i18n, and Event Publication unlike the basic BeanFactory.
        ApplicationContext context = SpringApplication.run(Application.class, args);

        // --- DEPENDENCY LOOKUP (Anti-pattern) ---
        // Actively asking the context for a bean is an anti-pattern in business logic.
        // It's shown here only to demonstrate how the container holds the beans.
        OrderService service = context.getBean(OrderService.class);

        service.completeOrder(250.0);
    }
}
