package com.otus.testservice.service.impl;

import com.otus.testservice.entity.User;
import com.otus.testservice.repository.UserRepository;
import com.otus.testservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("currencyService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
