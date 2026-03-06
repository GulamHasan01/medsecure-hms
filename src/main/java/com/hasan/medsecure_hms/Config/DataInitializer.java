package com.hasan.medsecure_hms.Config;

import com.hasan.medsecure_hms.Model.Role;
import com.hasan.medsecure_hms.Model.User;
import com.hasan.medsecure_hms.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository repo, PasswordEncoder encoder) {
        return args -> {

            if (repo.count() == 0) {

                repo.save(User.builder()
                        .name("Admin User")
                        .username("admin")
                        .role(Role.ADMIN)
                        .address("Delhi")
                        .phoneNo("9999999999")
                        .email("admin@test.com")
                        .password(encoder.encode("admin123"))
                        .build());

                repo.save(User.builder()
                        .name("Doctor Raj")
                        .username("doctor")
                        .role(Role.DOCTOR)
                        .address("Mumbai")
                        .phoneNo("8888888888")
                        .email("doctor@test.com")
                        .password(encoder.encode("doctor123"))
                        .build());

                repo.save(User.builder()
                        .name("Patient Ravi")
                        .username("patient")
                        .role(Role.PATIENT)
                        .address("Pune")
                        .phoneNo("7777777777")
                        .email("patient@test.com")
                        .password(encoder.encode("patient123"))
                        .build());

                System.out.println("Default users inserted!");
            }
        };
    }
}