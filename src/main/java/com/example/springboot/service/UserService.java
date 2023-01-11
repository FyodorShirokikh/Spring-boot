package com.example.springboot.service;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void add(User user) {
        userRepository.save(user);
    }
    public User showUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> showUsers() {
        return userRepository.findAll();
    }
}
