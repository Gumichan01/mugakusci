package com.example.mugakusci.controller;

import com.example.mugakusci.client.IClient;
import com.example.mugakusci.client.hal.HalClient;
import com.example.mugakusci.client.hal.HalResponse;
import com.example.mugakusci.domain.BasicEntry;
import com.example.mugakusci.domain.model.SearchResponse;
import com.example.mugakusci.domain.model.SimpleQuery;
import com.example.mugakusci.domain.service.HalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/api/v1/search/")
    public BasicEntry search(@RequestParam(value = "q") String query) {
        // TODO Set proper client
        SearchResponse result = new HalService(new HalClient()).search(new SimpleQuery(query));
        //return result;
        System.out.println("Result:");
        System.out.println(result);
        return new BasicEntry("test", "http://localhost:8080/hello");
    }
}
