package com.zipc.epm.web.service;

import java.util.List;

import com.zipc.epm.web.entity.User;

public interface UserService {

    void add(User user);

    User findById(long id);

    List<User> findAll();

    User findByEmail(String email);

}
