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

        http.authorizeHttpRequests(auth ->
                auth.anyRequest().permitAll()
                        // .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        // .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        // .requestMatchers(HttpMethod.GET, "/users").authenticated()
                        // .requestMatchers(HttpMethod.GET, "/navio").authenticated()
                        // .requestMatchers(HttpMethod.POST, "/navio").authenticated()
                        // .requestMatchers(HttpMethod.DELETE, "/navio").authenticated()
                        // .requestMatchers(HttpMethod.PUT, "/navio").authenticated()
                        
        );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}