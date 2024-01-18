package com.artemnizhnyk.someapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class MainController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
