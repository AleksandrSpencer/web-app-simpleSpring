package com.spencer.webappsimpleSpring.services;

import com.spencer.webappsimpleSpring.entities.User;
import com.spencer.webappsimpleSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findById(username).get();
    }
}
