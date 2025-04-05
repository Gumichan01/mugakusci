package com.example.mugakusci.client.theses;

import com.example.mugakusci.client.IClient;
import com.example.mugakusci.domain.model.SimpleQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ThesesClient implements IClient<ThesesResponse> {

    private final RestClient client;
    public ThesesClient(RestClient.Builder restClientBuilder) {
        this.client = restClientBuilder.baseUrl("https://theses.fr").build();
    }

    @Override
    public ThesesResponse retrieveResults(SimpleQuery query) {
        return this.client.get().uri("/api/v1/theses/recherche/?q=" + query.query() + "&nb=10").retrieve().body(ThesesResponse.class);
    }
}
