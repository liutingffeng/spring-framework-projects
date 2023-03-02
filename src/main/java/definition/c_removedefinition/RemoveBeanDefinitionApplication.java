package definition.c_removedefinition;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RemoveBeanDefinitionApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("definition/remove-definitions.xml");
        Person aqiang = (Person) ctx.getBean("aqiang");
        System.out.println(aqiang);
    }
}
