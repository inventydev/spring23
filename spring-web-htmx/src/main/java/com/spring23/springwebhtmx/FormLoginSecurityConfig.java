package com.spring23.springwebhtmx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class FormLoginSecurityConfig {

    @Autowired
    private Environment env;

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login.html")
                .failureUrl("/login-error.html")
                .and()
                .logout()
                .logoutSuccessUrl("/index.html")
                .and();

        http.authorizeHttpRequests()
                .requestMatchers(r -> r.getMethod().equals("POST")
                        && r.getServletPath().equals("/clicked"))
                .permitAll();

        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username(env.getProperty("spring.security.user.name"))
                .password(env.getProperty("spring.security.user.password"))
                .roles("USER")

                .build();
        UserDetails admin = User.builder()
                .username(env.getProperty("spring.security.admin.name"))
                .password(env.getProperty("spring.security.admin.password"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

}
