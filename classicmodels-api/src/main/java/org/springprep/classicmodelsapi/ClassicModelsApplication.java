package org.springprep.classicmodelsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ClassicModelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassicModelsApplication.class, args);
    }
}
