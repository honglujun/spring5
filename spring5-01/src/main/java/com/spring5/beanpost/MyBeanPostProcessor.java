package com.spring5.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 后置bean处理类
 */
public class MyBeanPostProcessor  implements BeanPostProcessor {

    /**
     * 这里返回null 也不影响后面的after方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 对所有的bean都会处理，所以需要判断类型
        if (bean instanceof Category) {
            Category c = (Category) bean;
            c.setName("lisi");
        }
        return bean;
    }
}
