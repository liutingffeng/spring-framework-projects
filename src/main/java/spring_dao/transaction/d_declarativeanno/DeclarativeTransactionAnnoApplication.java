package spring_dao.transaction.d_declarativeanno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dao.transaction.d_declarativeanno.config.DeclarativeTransactionConfiguration;
import spring_dao.transaction.d_declarativeanno.service.AccountService;

public class DeclarativeTransactionAnnoApplication {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                DeclarativeTransactionConfiguration.class);
//        UserService userService = ctx.getBean(UserService.class);
//        userService.saveAndQuery();

        AccountService accountService = ctx.getBean(AccountService.class);
        accountService.transfer(1, 2, 100);
    }
}
