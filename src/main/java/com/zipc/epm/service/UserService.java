package com.zipc.epm.service;

import java.util.List;

import com.zipc.epm.entity.User;

public interface UserService {

    void add(User user);

    User findById(long id);

    List<User> findAll();

    User findByEmail(String email);

}
