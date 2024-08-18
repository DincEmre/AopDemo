package com.example.aopdemo.service;

import com.example.aopdemo.model.User;
import org.springframework.stereotype.Service;

/**
 * @author Emre Dinç
 */

@Service
public class UserService {

    // Örnek kullanıcı, normalde bu bir veritabanından gelir
    private static final User DUMMY_USER = new User("testuser", "password123");

    public boolean login(User user) {
        // Basit kullanıcı doğrulaması
        if (DUMMY_USER.getUsername().equals(user.getUsername()) &&
                DUMMY_USER.getPassword().equals(user.getPassword())) {
            return true;
        }
        return false;
    }
}

