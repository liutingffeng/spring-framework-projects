package aop.h_imitate.prcessor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.aspectj.lang.annotation.*;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class AopProxyPostProcessor implements BeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    private Map<PointcutExpression, Method> beforePointcutMethodMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void initAspectAndPointcuts() {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();
            if (!StringUtils.hasLength(beanClassName)) {
                continue;
            }
            Class<?> clazz = ClassUtils.resolveClassName(beanClassName, ClassUtils.getDefaultClassLoader());
            if (!clazz.isAnnotationPresent(Aspect.class)) {
                continue;
            }

            PointcutParser pointcutParser = PointcutParser.
                    getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();
            ReflectionUtils.doWithMethods(clazz, method -> {
                Before before = method.getAnnotation(Before.class);
                if (before != null) {
                    String pointcutExp = before.value();
                    try {
                        PointcutExpression pointcutExpression = pointcutParser.parsePointcutExpression(pointcutExp);
                        beforePointcutMethodMap.put(pointcutExpression, method);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, method -> {
                return method.isAnnotationPresent(Before.class)
                        || method.isAnnotationPresent(After.class)
                        || method.isAnnotationPresent(AfterReturning.class)
                        || method.isAnnotationPresent(AfterThrowing.class)
                        || method.isAnnotationPresent(Around.class);
            });
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Aspect.class)) {
            return bean;
        }

        List<Method> proxyMethods = new ArrayList<>();
        beforePointcutMethodMap.forEach(((pointcutExpression, method) -> {
            if (pointcutExpression.couldMatchJoinPointsInType(bean.getClass())) {
                proxyMethods.add(method);
            }
        }));

        if (proxyMethods.isEmpty()) {
            return bean;
        }

        return Enhancer.create(bean.getClass(), (MethodInterceptor)(proxy, method, args, methodProxy) -> {
            for (Method proxyMethod:
                 proxyMethods) {
                Object aspectBean = beanFactory.getBean(proxyMethod.getDeclaringClass());
                proxyMethod.invoke(aspectBean);
            }
            return methodProxy.invokeSuper(proxy, args);
        });
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }
}
