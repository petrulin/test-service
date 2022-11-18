package com.otus.testservice.service;

import com.otus.testservice.entity.User;

public interface UserService {

    User save(User user);
    User findById(Long id);
    void deleteById(Long id);
}
