package com.shdinesh.springcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CrudController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome Spring Boot Stored Procedure and Function execution";
    }
}
