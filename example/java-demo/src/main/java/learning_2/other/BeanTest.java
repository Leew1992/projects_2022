package learning_2.other;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;


/**
 * 实例化 Instantiation
 * 属性赋值 populate
 * 初始化 initializing
 * 销毁 destruction
 */
public class BeanTest implements InstantiationAwareBeanPostProcessor
        , BeanNameAware, BeanClassLoaderAware, BeanFactoryAware
        , InitializingBean
        , DisposableBean {

    @Nullable
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }

    // ===============================================


    @Override
    public void setBeanName(String s) {

    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    // ===============================================

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    // ---------------------------------------------------

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    // ---------------------------------------------------

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    // ===============================================


    @Override
    public void destroy() throws Exception {

    }
}
