package com.example.mugakusci.client.hal;

import com.example.mugakusci.client.IClient;
import com.example.mugakusci.domain.model.SimpleQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HalClient implements IClient<HalResponse> {

    private final RestClient client;

    public HalClient(RestClient.Builder restClientBuilder) {
        this.client = restClientBuilder.baseUrl("https://api.archives-ouvertes.fr").build();
    }

    @Override
    public HalResponse retrieveResults(SimpleQuery query) {
        return this.client.get().uri("/search/?q=" + query.query() + "&rows=10&wt=json").retrieve().body(HalResponse.class);
    }
}
