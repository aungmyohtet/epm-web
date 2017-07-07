package com.zipc.epm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zipc.epm.web.entity.User;
import com.zipc.epm.web.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void add(User user) {
        userRepository.add(user);
    }

    @Override
    @Transactional
    public User findById(long id) {
        return null;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return null;
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
