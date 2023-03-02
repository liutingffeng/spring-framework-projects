package postprocessor.b_getproperty;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PostProcessorGetPropertyApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("postprocessor.b_getproperty");
        ctx.close();
    }
}
