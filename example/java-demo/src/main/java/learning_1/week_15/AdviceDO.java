package learning_1.week_15;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdviceDO {

    @Pointcut("execution(* week_15.LogicDO.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinpoint) {
        System.out.println("前置通知："+joinpoint);
        System.out.println("被植入增强处理的目标方法为："+joinpoint.getSignature().getName());
    }
}
