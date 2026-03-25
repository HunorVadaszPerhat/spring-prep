package org.springprep.classicmodelsapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI classicModelsApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Classic Models API")
                        .description("REST API surface providing CRUD access to the classicmodels dataset")
                        .version("v1")
                        .license(new License().name("Apache 2.0")));
    }
}
