package learning_2.other;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

    @Pointcut("execution(* learning_2.other.DemoController.*(..)))")
    public void pointcut() {}

    @Before("pointcut()")
    public void record(JoinPoint joinPoint) {
        System.out.println("method: " + joinPoint.getSignature().getName() + "; request time: " + System.currentTimeMillis());
    }

}
