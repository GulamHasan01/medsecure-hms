package com.hasan.medsecure_hms.Controller;

import com.hasan.medsecure_hms.Dtos.Request.LoginRequest;
import com.hasan.medsecure_hms.Dtos.Request.RegisterRequest;
import com.hasan.medsecure_hms.Dtos.Response.RegisterResponse;
import com.hasan.medsecure_hms.Services.AuthServices;
import com.hasan.medsecure_hms.Services.UserServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthServices authServices;


    public AuthController( AuthServices authServices) {
        this.authServices = authServices;

    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authServices.verify(request);
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        return authServices.register(request);
    }
}
