package com.jesus.facturacion_desarrollo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)  throws Exception {
        httpSecurity.csrf(
                crsf -> crsf.disable()
        ).authorizeHttpRequests(
                auth ->{
                    auth.requestMatchers("/api/v1/productos/**").permitAll()
                            .anyRequest().authenticated();
                }
        ).httpBasic(Customizer.withDefaults());

    return httpSecurity.build();
    }
}
