package com.hasan.medsecure_hms.Services;

import com.hasan.medsecure_hms.Dtos.Request.UpdateUserRequest;
import com.hasan.medsecure_hms.Model.User;
import com.hasan.medsecure_hms.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements UserDetailsService {

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

    public User getById(Long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not Found!"));
    }

    public User updateMe(Long id, UpdateUserRequest updateUserRequest) throws Exception {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not Found!"));

        if (updateUserRequest.getUsername() != null) {
            existingUser.setUsername(updateUserRequest.getUsername());
        }

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) throws Exception {

        if (!userRepository.existsById(id)) {
            throw new Exception("User with ID " + id + " does not exist.");
        }

        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
    }
}