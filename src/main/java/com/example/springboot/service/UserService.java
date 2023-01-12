package com.example.springboot.service;

import com.example.springboot.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    User showUser(Long id);
    void edit(Long id, User user);

    void delete(Long id);

    List<User> showUsers();

}
