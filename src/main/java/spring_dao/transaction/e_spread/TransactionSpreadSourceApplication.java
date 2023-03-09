package spring_dao.transaction.e_spread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dao.transaction.e_spread.config.TransactionSpreadConfiguration;
import transaction.config.TransactionAspectConfiguration;

public class TransactionSpreadSourceApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransactionSpreadConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.register();
    }
}
