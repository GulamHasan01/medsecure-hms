package com.hasan.medsecure_hms.Dtos.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterResponse {

    @NotBlank
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
}
