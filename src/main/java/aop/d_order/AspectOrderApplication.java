package aop.d_order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectOrderApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectOrderConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.saveUser("abc");
    }
}
