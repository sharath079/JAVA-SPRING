package kun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfig.class,PersistanceConfig.class})
@ComponentScan(basePackages = "kun")
public class AppConfig {

}
