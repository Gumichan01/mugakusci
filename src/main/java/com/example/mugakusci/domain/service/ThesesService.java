package com.example.mugakusci.domain.service;

import com.example.mugakusci.client.IClient;
import com.example.mugakusci.client.theses.ThesesResponse;
import com.example.mugakusci.client.theses.ThesesResultEntry;
import com.example.mugakusci.domain.model.SearchResponse;
import com.example.mugakusci.domain.model.SimpleQuery;
import com.example.mugakusci.domain.model.entry.SimpleEntry;

import java.util.List;

public class ThesesService implements IService {

    private final IClient<ThesesResponse> client;

    public ThesesService(IClient<ThesesResponse> client) {
        this.client = client;
    }

    @Override
    public SearchResponse search(SimpleQuery query) {
        ThesesResponse response = this.client.retrieveResults(query);

        if (response != null) {
            List<SimpleEntry> entries = response.docs().stream().filter(ThesesResultEntry::isPresented)
                    .map(doc -> new SimpleEntry(doc.label(), doc.link())).toList();
            return new SearchResponse(entries.size(), entries);
        } else {
            return new SearchResponse(0, null);
        }
    }
}
