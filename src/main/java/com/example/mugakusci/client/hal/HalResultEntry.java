package com.example.mugakusci.client.hal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record HalResultEntry(int docid, @JsonProperty("label_s") String label, @JsonProperty("uri_s") String uri) {
}
