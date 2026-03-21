package org.springprep.practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof LifeCycleBean) {
            System.out.println("6 BeanPostProcess before init, postProcessBeforeInitialization(\"" + beanName + "\")");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof LifeCycleBean) {
            System.out.println("10 BeanPostProcess after init, postProcessAfterInitialization(\"" + beanName + "\")");
        }
        return bean;
    }

}
