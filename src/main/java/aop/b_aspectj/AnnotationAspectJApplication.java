package aop.b_aspectj;

import aop.b_aspectj.config.AspectJAOPConfiguration;
import aop.b_aspectj.service.FinanceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationAspectJApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectJAOPConfiguration.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.addMoney(123.45);
        financeService.subtractMoney(543.21);
        financeService.getMoneyById("abc");
    }
}
