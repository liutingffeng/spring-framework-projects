package transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import transaction.config.TransactionAspectConfiguration;
import transaction.service.FinanceService;

public class TransactionApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransactionAspectConfiguration.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.transfer(1L, 2L, 100);
    }
}
