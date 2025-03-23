package com.example.mugakusci.client;

import com.example.mugakusci.domain.model.SimpleQuery;

public interface IClient<R> {
    R retrieveResults(SimpleQuery query);
}
