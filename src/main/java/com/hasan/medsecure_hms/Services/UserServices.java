package com.hasan.medsecure_hms.Services;

import com.hasan.medsecure_hms.Dtos.Request.UpdateUserRequest;
import com.hasan.medsecure_hms.Model.User;
import com.hasan.medsecure_hms.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByEmail(String email) throws Exception {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("User Not Found!"));
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getById(long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not Found!"));
    }

    public User updateMe(long id, UpdateUserRequest updateUserRequest) throws Exception {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not Found!"));


        if (updateUserRequest.getUsername() != null) {
            existingUser.setUsername(updateUserRequest.getUsername());
        }

        return userRepository.save(existingUser);
    }

    public void deleteUser(String id) throws Exception {
        // Best practice: Check if it exists first so you can throw a clean error
        if (!userRepository.existsById(id)) {
            throw new Exception("User with ID " + id + " does not exist.");
        }
        userRepository.deleteById(id);
    }
}