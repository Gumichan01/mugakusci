package com.example.mugakusci.domain.service;

import com.example.mugakusci.client.IClient;
import com.example.mugakusci.client.hal.HalResponse;
import com.example.mugakusci.domain.model.SearchResponse;
import com.example.mugakusci.domain.model.SimpleQuery;

public class HalService implements IService {

    private final IClient<HalResponse> client;

    public HalService(IClient<HalResponse> client) {
        this.client = client;
    }

    @Override
    public SearchResponse search(SimpleQuery query) {
        // TODO request to HAL
        HalResponse response = client.retrieveResults(query);
        System.out.println("HAL " + response);
        return new SearchResponse(0,null);
    }
}
