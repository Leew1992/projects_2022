package learning_1.week_12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Person person = (Person) context.getBean("PersonBean");
        System.out.println(person);
        // ((ClassPathXmlApplicationContext) context).destroy();
}
}
