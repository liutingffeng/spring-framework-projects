package spring_dao.transaction.e_spread;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionSpreadApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx/transaction-spread.xml");
        UserService userService = ctx.getBean(UserService.class);
        userService.register();
    }
}
