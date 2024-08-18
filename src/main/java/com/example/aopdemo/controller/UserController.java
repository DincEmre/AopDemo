package com.example.aopdemo.controller;

import com.example.aopdemo.model.User;
import com.example.aopdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Emre Dinç
 */

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean isSuccess = userService.login(user);
        return isSuccess ? "Giriş başarılı!" : "Giriş başarısız!";
    }
}
