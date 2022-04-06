package technifutur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    @Bean//instance de PasswordEncoder gérée par le container

    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
