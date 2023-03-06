package transaction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("transaction")
@EnableAspectJAutoProxy
public class TransactionAspectConfiguration {
}
