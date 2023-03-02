package h_propertyxml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceXmlApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcXmlConfiguration.class);
        System.out.println(ctx.getBean(JdbcXmlProperty.class).toString());
    }
}
