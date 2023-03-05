package aop.d_order;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop.d_order")
@EnableAspectJAutoProxy
public class AspectOrderConfiguration {
}
