package aop.d_order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AbcAspect {

    @Before("execution(* aop.d_order.UserService.*(..))")
    public void abc() {
        System.out.println("abc abc abc");
    }
}
