package com.hasan.medsecure_hms.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Indexed;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;


    private String Name;

    private String username;

    private String Role;

    private String Address;

    private String Phone_no;

    @NotBlank
    private String Password;

    @NotBlank
    private String email;

    @CreatedDate
    private Instant CreatedAt;
    @LastModifiedDate
    private Instant UpdatedAt;
}
