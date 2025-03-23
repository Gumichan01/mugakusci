package com.example.mugakusci.client.hal;

import com.example.mugakusci.client.IClient;
import com.example.mugakusci.domain.model.SimpleQuery;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

public class HalClient implements IClient<HalResponse> {
    @Override
    public HalResponse retrieveResults(SimpleQuery query) {
        RestClient client = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                //.baseUrl("https://api.archives-ouvertes.fr")
                .build();
        // TODO JSON to Object
        return client.get().uri("https://api.archives-ouvertes.fr/search/?q=" + query.query() + "&rows=10&wt=json")
                .retrieve().body(HalResponse.class);
    }
}
