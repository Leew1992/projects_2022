package learning_2.week_18;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ApplicationContextTest {

    public static void main(String[] args) {
        // testXmlBeanFactory();
        testClassPath();
        // testAnnotation();
    }

    private static void testXmlBeanFactory() {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        Object obj = factory.getBean("objectService");
        System.out.println(obj);
    }

    private static void testClassPath() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
        Object aaa = context.getBean("objectService");
        Object bbb = context.getBean("objectService");
        System.out.println(aaa);
        System.out.println(bbb);

    }

    private static void testAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigTest.class);
        Object aaa = context.getBean("objectService");
        System.out.println(aaa);
    }
}
