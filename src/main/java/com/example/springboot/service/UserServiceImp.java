package com.example.springboot.service;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void add(User user) {
        userRepository.save(user);
    }
    @Override
    public User showUser(Long id) {
        return userRepository.findById(id);
    }
    @Override
    public void edit(Long id, User user) {
        userRepository.edit(id, user);
    }
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<User> showUsers() {
        return userRepository.findAll();
    }
}
