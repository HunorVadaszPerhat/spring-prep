package org.springprep.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        System.out.println("Context starting - INIT phase");
        // SpringApplication.run(PracticeApplication.class, args);
        ConfigurableApplicationContext ctx = SpringApplication.run(
                PracticeApplication.class, args
        );

        System.out.println("Bean is use - ACTIVE phase");

        LifeCycleBean bean = ctx.getBean(LifeCycleBean.class);
        bean.doWork();

        System.out.println("Context closing - DESTROY phase");

        ctx.close(); // triggers pre-destroy callbacks




    }

}
