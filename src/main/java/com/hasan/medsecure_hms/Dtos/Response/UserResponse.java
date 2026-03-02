package com.hasan.medsecure_hms.Dtos.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
@Builder
public class UserResponse {


    private String id;
    private String Name;
    private String username;
    private String Role;
    private String Address;
    private String Phone_no;
    private String Password;
    private String Email;
    private Instant CreatedAt;
    private Instant UpdatedAt;

}
