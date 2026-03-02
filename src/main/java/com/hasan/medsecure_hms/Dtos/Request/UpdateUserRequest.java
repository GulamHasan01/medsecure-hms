package com.hasan.medsecure_hms.Dtos.Request;

import com.hasan.medsecure_hms.Model.Role;
import lombok.Data;

import java.time.Instant;

@Data
public class UpdateUserRequest {
    private String id;
    private String Name;
    private String username;
    private Role Role;
    private String Address;
    private String Phone_no;
    private String Password;
    private String Email;
    private Instant CreatedAt;
    private Instant UpdatedAt;

}
