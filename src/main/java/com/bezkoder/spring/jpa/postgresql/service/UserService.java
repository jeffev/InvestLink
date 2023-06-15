package com.bezkoder.spring.jpa.postgresql.service;

import com.bezkoder.spring.jpa.postgresql.model.User;
import com.bezkoder.spring.jpa.postgresql.model.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void saveUser(User user);
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}