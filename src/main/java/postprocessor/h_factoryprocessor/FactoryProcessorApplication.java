package postprocessor.h_factoryprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryProcessorApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("postprocessor.h_factoryprocessor");
        Red red = ctx.getBean(Red.class);
        System.out.println(red);
    }
}
