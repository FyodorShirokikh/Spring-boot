package com.example.springboot.repository;

import com.example.springboot.model.User;
import java.util.List;

public interface UserRepository{
    void save(User user);
    User findById(Long id);
    void edit(Long id, User user);
    void deleteById(Long id);
    List<User> findAll();
}
