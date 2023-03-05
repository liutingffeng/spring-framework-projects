package aop.h_imitate;

import aop.h_imitate.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImitateAopApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("aop.h_imitate");
        UserService userService = ctx.getBean(UserService.class);
        userService.get("adc");
    }
}
