package com.example.mugakusci.domain.service;

import com.example.mugakusci.client.IClient;
import com.example.mugakusci.client.hal.HalResponse;
import com.example.mugakusci.domain.model.SearchResponse;
import com.example.mugakusci.domain.model.SimpleQuery;
import com.example.mugakusci.domain.model.entry.SimpleEntry;

import java.util.List;


public class HalService implements IService {

    private final IClient<HalResponse> client;

    public HalService(IClient<HalResponse> client) {
        this.client = client;
    }

    @Override
    public SearchResponse search(SimpleQuery query) {
        HalResponse response = this.client.retrieveResults(query);
        if (response != null) {
            List<SimpleEntry> entries = response.body().docs().stream().map(doc -> new SimpleEntry(doc.label(), doc.uri())).toList();
            return new SearchResponse(response.body().docs().size(), entries);
        } else {
            return new SearchResponse(0, null);
        }
    }
}
