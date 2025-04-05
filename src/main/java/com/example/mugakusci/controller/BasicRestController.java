package com.example.mugakusci.controller;

import com.example.mugakusci.client.hal.HalClient;
import com.example.mugakusci.client.theses.ThesesClient;
import com.example.mugakusci.domain.model.SearchResponse;
import com.example.mugakusci.domain.model.SimpleQuery;
import com.example.mugakusci.domain.service.HalService;
import com.example.mugakusci.domain.service.ThesesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class BasicRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/api/v1/search/")
    public SearchResponse search(@RequestParam(value = "q") String query) {
        return new ThesesService(new ThesesClient(RestClient.builder())).search(new SimpleQuery(query));
        //return new HalService(new HalClient(RestClient.builder())).search(new SimpleQuery(query));
    }
}
