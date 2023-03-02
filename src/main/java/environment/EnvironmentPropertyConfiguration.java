package environment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("environment")
@PropertySource("propertysource/jdbc.properties")
public class EnvironmentPropertyConfiguration {
}
