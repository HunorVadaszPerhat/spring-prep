package org.beanlifcycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeanLifcycleApplication {

    public static void main(String[] args) {
        System.out.println("\n=== Context starting — INIT phase ===\n");

        ConfigurableApplicationContext ctx =
                SpringApplication.run(BeanLifcycleApplication.class, args);

        System.out.println("\n=== Bean in use — ACTIVE phase ===\n");

        LifecycleBean bean = ctx.getBean(LifecycleBean.class);
        bean.doWork();

        System.out.println("\n=== Context closing — DESTROY phase ===\n");

        ctx.close(); // triggers pre-destroy callbacks
    }

}
