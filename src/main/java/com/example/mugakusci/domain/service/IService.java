package com.example.mugakusci.domain.service;

import com.example.mugakusci.domain.model.SearchResponse;
import com.example.mugakusci.domain.model.SimpleQuery;

public interface IService {
    SearchResponse search(SimpleQuery query);
}
