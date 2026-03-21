package org.springprep.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public LifeCycleBean lifeCycleBean() {
        LifeCycleBean bean = new LifeCycleBean();
        bean.setMessage("Hello from spring lifecycle project.");
        return bean;
    }
}
