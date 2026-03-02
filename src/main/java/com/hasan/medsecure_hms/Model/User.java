package com.hasan.medsecure_hms.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users")  // avoid reserved keyword "user"
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // must be numeric for IDENTITY

    private String name;

    @Column(unique = true)
    private String username;

    private String role;

    private String address;

    private String phoneNo;

    @NotBlank
    private String password;

    @NotBlank
    @Column(unique = true)
    private String email;
}