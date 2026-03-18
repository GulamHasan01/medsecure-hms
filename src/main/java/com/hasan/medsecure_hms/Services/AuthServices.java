package com.hasan.medsecure_hms.Services;

import com.hasan.medsecure_hms.Dtos.Request.LoginRequest;
import com.hasan.medsecure_hms.Dtos.Request.RegisterRequest;
import com.hasan.medsecure_hms.Dtos.Response.RegisterResponse;
import com.hasan.medsecure_hms.Model.Role;
import com.hasan.medsecure_hms.Model.User;
import com.hasan.medsecure_hms.Repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthServices(UserRepository userRepository,
                        PasswordEncoder passwordEncoder,
                        AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public RegisterResponse register(RegisterRequest request) {

        userRepository.findByUsername(request.getUsername())
                .ifPresent(user -> {
                    throw new RuntimeException("Username already exists!");
                });

        userRepository.findByEmail(request.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("Email already exists!");
                });

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(Role.PATIENT);

        User savedUser = userRepository.save(user);

        RegisterResponse res = new RegisterResponse();
        res.setId(savedUser.getId());
        res.setUsername(savedUser.getUsername());
        res.setEmail(savedUser.getEmail());

        return res;
    }

    public String verify(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        if (authentication.isAuthenticated()) {
            return "Login Successful";
        }

        throw new RuntimeException("Invalid credentials");
    }
}