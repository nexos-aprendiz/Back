package com.nexos.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Login")
public class AuthRest {
	
	
    @GetMapping("/login")
    public void login() {

    }
}
