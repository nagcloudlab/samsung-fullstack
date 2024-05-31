package auto.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "my", name = "foo", havingValue = "bar", matchIfMissing = true)
public class MyAutoConfiguration {

    @Bean
    public String bean1() {
        return "bean1";
    }

}