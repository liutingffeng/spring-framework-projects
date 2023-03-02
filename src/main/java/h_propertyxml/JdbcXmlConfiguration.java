package h_propertyxml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("h_propertyxml")
@PropertySource("classpath:propertysource/jdbc.xml")
public class JdbcXmlConfiguration {
}
