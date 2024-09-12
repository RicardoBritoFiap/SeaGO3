package com.fiap.seago.empresa.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth -> auth
                        // .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        // .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        // .requestMatchers(HttpMethod.GET, "/users").authenticated()
                        // .requestMatchers(HttpMethod.GET, "/navios").authenticated()
                        // .requestMatchers(HttpMethod.POST, "/navios").authenticated()
                        // .requestMatchers(HttpMethod.DELETE, "/navios").authenticated()
                        // .requestMatchers(HttpMethod.PUT, "/navios").authenticated() 
                        .anyRequest().permitAll()
        );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}