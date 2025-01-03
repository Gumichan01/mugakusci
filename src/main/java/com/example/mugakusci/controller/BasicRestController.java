package com.example.mugakusci.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "q") String query) {
        return "echo " + query;
    }
}
