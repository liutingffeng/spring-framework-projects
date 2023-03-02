package aop.a_xmlaspect.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAspectApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop/xmlaspect.xml");
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.addMoney(5.33);
        financeService.subtractMoney(123.35);
        System.out.println(financeService.getMoneyById("abc"));
    }
}
