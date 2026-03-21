package org.springprep.practice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LifeCycleBean implements BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean
{
    private String message;

    // 1. constructor
    public LifeCycleBean() {
        log("1 - constructor");
    }

    // 2. setter injection
    public void setMessage(String message) {
        this.message = message;
        log("2 setter injection, message " + message);
    }

    // 3. BeanNameAware
    @Override
    public void setBeanName(String name) {
        log("3 BeanNameAware, bean name: " + name);
    }

    // 4. BeanFactoryAware
    @Override
    public void setBeanFactory(BeanFactory factory) throws BeansException {
        log("4 BeanFactoryAware, factory: " + factory.getClass().getSimpleName());
    }

    // 5. ApplicationContextAware
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        log("5 ApplicationContextAware, context: " + ctx.getClass().getSimpleName());
    }

    // 6. BeanPostProcessor.before - handled externally ( see LifecycleBeanPostProcessor)

    // 7. @PostConstruct (JSR-250)
    @PostConstruct
    public void postConstruct() {
        log("7 @PostConstruct");
    }

    // 8. InitializingBean
    @Override
    public void afterPropertiesSet() {
        log("8 InitializingBean afterPropertiesSet()");
    }

    // 9. @Bean(initMethod) - declared in AppConfig
    public void customInit() {
        log("9 initMethod customInit() via @Bean(initMethod)");
    }

    // 10. BeanPostProcessor.after - handled externally

    // 11. Bean is live here
    public void doWork() {
        log("11 in use doWork() called - message: " + message);
    }

    // 12. @PreDestroy (JSR-250)
    @PreDestroy
    public void preDestroy() {
        log("12 @PreDestroy");
    }

    // 13. DisposableBean
    @Override
    public void destroy() {

    }

    // 14. @Bean(destroyMethod) - declared in AppConfig
    public void customDestroy() {
        log("14 destroyMethod customDestroy() via @Bean(destroyMethod)");
    }

    private void log(String msg) {
        System.out.println("  " + msg);
    }
}
