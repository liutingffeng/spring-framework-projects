package aop.d_order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect implements Ordered {

    @Before("execution(* aop.d_order.UserService.*(..))")
    public void beginTransaction() {
        System.out.println("TransactionAspect 开启事务 ......");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
