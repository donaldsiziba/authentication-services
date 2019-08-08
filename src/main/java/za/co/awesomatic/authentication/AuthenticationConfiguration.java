package za.co.awesomatic.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.awesomatic.tdd.PasswordValidator;
import za.co.awesomatic.tdd.RuleBasedPasswordValidator;

@Configuration
public class AuthenticationConfiguration {
    @Bean
    PasswordValidator passwordValidator() {
        return new RuleBasedPasswordValidator();
    }
}
