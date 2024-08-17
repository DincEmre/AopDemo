package com.example.aopdemo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.aopdemo.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Emre Dinç
 */

@RestController
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/dosomething")
    public String doSomething() {
        return myService.doSomething();
    }
}
