package technifutur.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder;

    public WebSecurityConfig(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("pass")).authorities("USER")
                .and()
                .withUser("admin").password(encoder.encode("pass")).authorities("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //cross site request for jerry
        http.csrf().disable();

        http.httpBasic();

        http.sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);// pour ne pas
        //enregistrer de COOKIE

        http.authorizeRequests()
                .antMatchers("/demo/for-connected").authenticated()
                .antMatchers("/demo/for-user").hasAuthority("USER")
                .antMatchers("/demo/for-admin").hasAuthority("ADMIN")
                .anyRequest().permitAll();

    }
}
