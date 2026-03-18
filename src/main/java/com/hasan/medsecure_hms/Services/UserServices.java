package com.hasan.medsecure_hms.Services;

import com.hasan.medsecure_hms.Dtos.Request.UpdateUserRequest;
import com.hasan.medsecure_hms.Model.User;
import com.hasan.medsecure_hms.Repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    public User updateMe(UpdateUserRequest req) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        assert auth != null;
        String username = auth.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (req.getUsername() != null) {
            user.setUsername(req.getUsername());
        }

        if (req.getEmail() != null) {
            user.setEmail(req.getEmail());
        }

        if (req.getName() != null) {
            user.setName(req.getName());
        }


        if (req.getAddress() != null) {
            user.setAddress(req.getAddress());
        }

        return userRepository.save(user);
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