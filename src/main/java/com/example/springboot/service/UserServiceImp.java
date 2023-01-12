package com.example.springboot.service;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public void add(User user) {
        userRepository.save(user);
    }
    @Override
    public User showUser(Long id) {
        return userRepository.findById(id);
    }
    @Override
    @Transactional
    public void edit(Long id, User user) {
        userRepository.edit(id, user);
    }
    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<User> showUsers() {
        return userRepository.findAll();
    }
}
