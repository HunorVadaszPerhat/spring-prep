package org.beanlifcycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor runs for EVERY bean in the context.
 * Steps 6 and 10 in the lifecycle.
 */
@Component
public class LifecycleBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof LifecycleBean) {
            System.out.println("  6  [BPP before init]   postProcessBeforeInitialization(\"" + beanName + "\")");
        }
        return bean; // must return the bean (or a wrapper/proxy)
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof LifecycleBean) {
            System.out.println("  10 [BPP after init]    postProcessAfterInitialization(\"" + beanName + "\") — proxy could be returned here");
        }
        return bean;
    }
}
