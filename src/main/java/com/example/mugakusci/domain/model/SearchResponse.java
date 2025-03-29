package com.example.mugakusci.domain.model;


import com.example.mugakusci.domain.model.entry.IEntry;

import java.util.List;

public record SearchResponse(int totalResults, List<? extends IEntry> entries) {
}
