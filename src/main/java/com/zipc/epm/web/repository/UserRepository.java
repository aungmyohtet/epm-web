package com.zipc.epm.web.repository;

import com.zipc.epm.web.entity.User;

public interface UserRepository {

    void add(User user);

    User findByEmail(String email);
}
