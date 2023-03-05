package aop.b_aspectj.component;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {

    @Pointcut("execution(* aop.b_aspectj.service.*.*(String)))")
    public void defaultPointcut() {

    }

//    @Before("execution(public * aop.b_aspectj.service.FinanceService.*(..))")
//    public void beforePrint() {
//        System.out.println("Logger beforePrint run ......");
//    }

//    @After("execution(* aop.b_aspectj.service.*.*(String)))")
//    @After("@annotation(aop.b_aspectj.component.Log)")
//    public void afterPrint() {
//        System.out.println("Logger afterPrint run ......");
//    }

//    @AfterReturning("defaultPointcut()")
    @AfterReturning(value = "execution(* aop.b_aspectj.service.FinanceService.subtractMoney(double))", returning = "retval")
    public void afterReturningPrint(Object retval) {
        System.out.println("返回的数据：" + retval);
        System.out.println("Logger afterReturningPrint run ......");
    }

//    @AfterThrowing("defaultPointcut()")
//    public void afterThrowingPrint() {
//        System.out.println("Logger afterThrowingPrint run ......");
//    }

//    @Around("execution(public * aop.b_aspectj.service.FinanceService.addMoney(..))")
//    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Logger aroundPrint before run ......");
//        try {
//            Object retVal = joinPoint.proceed();
//            System.out.println("Logger aroundPrint afterReturning run ......");
//            return retVal;
//        } catch (Throwable e) {
//            System.out.println("Logger aroundPrint afterThrowing run ......");
//            throw e;
//        } finally {
//            System.out.println("Logger aroundPrint after run ......");
//        }
//    }

}
