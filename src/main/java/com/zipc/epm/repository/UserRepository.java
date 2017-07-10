package com.zipc.epm.repository;

import com.zipc.epm.entity.User;

public interface UserRepository {

    void add(User user);

    User findByEmail(String email);
}
