package event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RegisterEventApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "event");
        RegisterService service = ctx.getBean(RegisterService.class);
        service.register("asddsa");
    }
}
