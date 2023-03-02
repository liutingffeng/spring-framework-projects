package i_propertyyml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceYmlApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcYmlConfiguration.class);
        System.out.println(ctx.getBean(JdbcYmlProperty.class).toString());
    }
}
