package com.hasan.medsecure_hms.Config;

import com.hasan.medsecure_hms.Services.UserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserServices userServices;

    public SecurityConfig(UserServices userServices) {
        this.userServices = userServices;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(userServices);

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/user/apis/PUBLIC/**").permitAll()

                        .requestMatchers("/user/apis/DOCTOR/**").hasRole("DOCTOR")

                        .requestMatchers("/user/apis/ADMIN/**").hasRole("ADMIN")

                        .requestMatchers("/user/apis/PATIENT/**").hasRole("PATIENT")

                        .anyRequest().authenticated()
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .logout(logout -> logout
                        .logoutUrl("/logout"));

        return http.build();
    }
}
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//
//        UserDetails admin = org.springframework.security.core.userdetails.User
//                .builder()
//                .username("admin")
//                .password(passwordEncoder.encode("admin123"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails doctor = org.springframework.security.core.userdetails.User
//                .builder()
//                .username("doctor")
//                .password(passwordEncoder.encode("doctor123"))
//                .roles("DOCTOR")
//                .build();
//
//        UserDetails patient = org.springframework.security.core.userdetails.User
//                .builder()
//                .username("patient")
//                .password(passwordEncoder.encode("patient123"))
//                .roles("PATIENT")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, doctor, patient);
//    }

