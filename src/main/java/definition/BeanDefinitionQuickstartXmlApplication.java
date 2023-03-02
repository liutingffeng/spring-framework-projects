package definition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDefinitionQuickstartXmlApplication {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("basic_all/definition-beans.xml");
//        BeanDefinition personBeanDefinition = ctx.getBeanFactory().getBeanDefinition("person");
//        System.out.println(personBeanDefinition);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("definition");
        BeanDefinition personBeanDefinition = ctx.getBeanFactory().getBeanDefinition("person");
        System.out.println(personBeanDefinition);
        System.out.println(personBeanDefinition.getClass().getName());
    }
}
