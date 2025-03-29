package com.example.mugakusci.client.hal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HalResponseBody(int numFOund, int start, List<HalResultEntry> docs) {
}
