package configuration.d_enablejdbc.anno;

import configuration.d_enablejdbc.config.JdbcConfiguration;
import configuration.d_enablejdbc.config.OnClassNameConditional;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnClassNameConditional.class)
public @interface ConditionalOnClassName {
    String value();
}
