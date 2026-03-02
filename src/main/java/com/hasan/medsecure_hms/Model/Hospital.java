package com.hasan.medsecure_hms.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "hospitals")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Hospital name is required")
    @Column(unique = true)
    private String name;

    private String email;
    private String address;
    private String contactNumber;

    @Column(unique = true)
    private String licenseNumber; // Sensitive internal data

    private String registrationDate;
}