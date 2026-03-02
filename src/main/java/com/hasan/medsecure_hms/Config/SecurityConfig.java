package com.hasan.medsecure_hms.Config;

import com.hasan.medsecure_hms.Model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity){
        httpSecurity.
                csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->auth
                        .requestMatchers("/PUBLIC/**").permitAll()
                        .requestMatchers("/DOCTOR/**").hasRole("DOCTOR")
                        .requestMatchers("/ADMIN").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll
                );
        return httpSecurity.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {

        UserDetails admin = org.springframework.security.core.userdetails.User
                .builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails doctor = org.springframework.security.core.userdetails.User
                .builder()
                .username("doctor")
                .password(passwordEncoder.encode("doctor123"))
                .roles("DOCTOR")
                .build();

        UserDetails patient = org.springframework.security.core.userdetails.User
                .builder()
                .username("patient")
                .password(passwordEncoder.encode("patient123"))
                .roles("PATIENT")
                .build();

        return new InMemoryUserDetailsManager(admin, doctor, patient);
    }
}
