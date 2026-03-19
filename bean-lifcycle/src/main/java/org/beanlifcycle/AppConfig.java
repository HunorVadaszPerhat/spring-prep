package org.beanlifcycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public LifecycleBean lifecycleBean() {
        LifecycleBean bean = new LifecycleBean();
        bean.setMessage("Hello from Spring 3.5 + Java 21");
        return bean;
    }
}
