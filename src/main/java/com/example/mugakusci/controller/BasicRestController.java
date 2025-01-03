package com.example.mugakusci.controller;

import com.example.mugakusci.domain.BasicEntry;
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
    public BasicEntry search(@RequestParam(value = "q") String query) {
        return new BasicEntry("test", "http://localhost:8080/hello");
    }
}
