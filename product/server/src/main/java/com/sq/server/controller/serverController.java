package com.sq.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class serverController {
    @GetMapping("/getProductMsg")
    public String msg() {
        return "hello client";
    }
}
