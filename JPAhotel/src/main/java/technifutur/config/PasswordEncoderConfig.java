package technifutur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import technifutur.crespin.JPAhotel.model.User;

@Configuration
public class PasswordEncoderConfig {

    @Bean//instance de PasswordEncoder gérée par le container

    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> new User();//remplace la methode load by user //sais pu
    }

}
