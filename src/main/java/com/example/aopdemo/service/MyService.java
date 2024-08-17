package com.example.aopdemo.service;

import org.springframework.stereotype.Service;

/**
 * @author Emre Dinç
 */

@Service
public class MyService {

    public String doSomething() {
        System.out.println("Doing something important...");
        return "Done!";
    }
}
