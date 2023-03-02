package programmatic;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.beans.Introspector;
import java.util.Set;

public class ProgrammaticInjectApplication2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        BeanDefinition personDefinition = BeanDefinitionBuilder.rootBeanDefinition(Person.class)
                .addPropertyValue("name", "老王").getBeanDefinition();
        ctx.registerBeanDefinition("laowang", personDefinition);

        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(ctx);
        scanner.addIncludeFilter(((metadataReader, metadataReaderFactory) -> {
            return metadataReader.getClassMetadata().getSuperClassName().equals(Animal.class.getName());
        }));

        Set<BeanDefinition> animalDefinitions = scanner.findCandidateComponents("programmatic");
        animalDefinitions.forEach(definition -> {
            System.out.println(definition);
            MutablePropertyValues propertyValues = definition.getPropertyValues();
            String beanClassName = definition.getBeanClassName();
            propertyValues.addPropertyValue("name", beanClassName);
            propertyValues.addPropertyValue("person", new RuntimeBeanReference("laowang"));
            ctx.registerBeanDefinition(Introspector.decapitalize(beanClassName.substring(beanClassName.lastIndexOf("."))),definition);
        });

        ctx.refresh();

        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
    }
}
