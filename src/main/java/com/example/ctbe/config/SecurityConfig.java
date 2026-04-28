package com.example.ctbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/actuator/**").permitAll()
                                .requestMatchers("/api/**", "/services/**").permitAll()
                                .anyRequest().permitAll()
                        //.anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable()); // for demo, disable CSRF (enable in production)
        return http.build();
    }
}
