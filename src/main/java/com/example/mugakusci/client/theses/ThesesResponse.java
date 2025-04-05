package com.example.mugakusci.client.theses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ThesesResponse(@JsonProperty("totalHits") int total,
                             @JsonProperty("theses") List<ThesesResultEntry> docs) {
}
