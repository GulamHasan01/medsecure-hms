package com.hasan.medsecure_hms.Controller;

import com.hasan.medsecure_hms.Dtos.Request.UpdateUserRequest;
import com.hasan.medsecure_hms.Model.User;
import com.hasan.medsecure_hms.Services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/apis")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    // GET all users
    @GetMapping("/ADMIN/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userServices.getAllUsers());
    }

    // GET user by ID
    @GetMapping("/PUBLIC/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(userServices.getById(id));
    }

    // PUT (Update) user
    @PutMapping("/PUBLIC/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UpdateUserRequest request) throws Exception {
        return ResponseEntity.ok(userServices.updateMe(id, request));
    }

    // DELETE user
    @DeleteMapping("/PUBLIC/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) throws Exception {
        userServices.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
    }
}