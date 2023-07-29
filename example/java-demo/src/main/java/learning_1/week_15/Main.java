package learning_1.week_15;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        LogicDO logicDO = (LogicDO) ctx.getBean("logicDO");
        logicDO.test();
    }
}
