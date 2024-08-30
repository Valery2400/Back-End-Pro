package de.ait.shop43.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {HttpMethod
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(

                x -> x
                        .requestMatchers(HttpMethod.GET, "/products").permitAll()  // разрешить всем GET на эндпоинт
                        .requestMatchers(HttpMethod.GET,"/products/{id}").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.POST,"/products").hasRole("ADMIN")
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());





        return http.build();
    }
}
