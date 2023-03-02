package g_propertysource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourcePropertiesApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcPropertiesConfiguration.class);
        System.out.println(ctx.getBean(JdbcProperties.class));
    }
}
