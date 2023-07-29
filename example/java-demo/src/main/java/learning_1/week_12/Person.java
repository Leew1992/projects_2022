package learning_1.week_12;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Person implements DisposableBean, InitializingBean, BeanFactoryAware, BeanNameAware, BeanClassLoaderAware {

    private String name;

    public Person() {
        System.out.println("Contructor of person bean is invoked!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory method of person is invoked!");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName method of person is invoked!");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader method of person is invoked!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy method of person is invoked!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method of person is invoked!");
    }

    public void init() {
        System.out.println("custom init method of person bean is invoked!");
    }

    public void destroyMethod() {
        System.out.println("custom Destroy method of person bean is invoked!");
    }
}
