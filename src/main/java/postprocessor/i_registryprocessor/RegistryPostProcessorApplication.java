package postprocessor.i_registryprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RegistryPostProcessorApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("postprocessor.i_registryprocessor");
        Cat cat = ctx.getBean(Cat.class);
        Dog dog = ctx.getBean(Dog.class);
        System.out.println(cat);
        System.out.println(dog);
    }
}
