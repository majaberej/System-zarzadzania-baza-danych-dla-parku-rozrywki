package BADA_PROJECT.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/img/**", "/js/**", "/css/**", "/index", "/o_nas", "/kontakt", "/login").permitAll()
                        .requestMatchers("/errors/403", "/errors/404", "/errors/500", "/errors/504", "/errors/other").permitAll()
                        .requestMatchers("/admin/**", "/css/adminStyles/**").hasRole("ADMIN")
                        .requestMatchers( "/user/**", "/css/userStyles/**").hasRole("USER")
                        .requestMatchers("/webjars/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/main", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/index")
                        .logoutSuccessUrl("/index")
                        .permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2y$10$zTf2gXlG1OZ9snxrWs2.jObCaq11dRjQ8xDELl9iXykmQqLkfgtLe")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2y$10$OUt3PJKRjxHatWd1SkQzLuzlKte/4yfZdaGmZJiB0cFTXO0/R03oa")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}