package com.bezkoder.spring.jpa.postgresql.utils;

import com.bezkoder.spring.jpa.postgresql.model.User;

import java.util.Map;

public interface JwtGeneratorInterface {
    Map<String, String> generateToken(User user);
}