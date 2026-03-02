package com.hasan.medsecure_hms.Dtos.Request;

import lombok.Data;

import java.time.Instant;

@Data
public class UpdateUserRequest {
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
