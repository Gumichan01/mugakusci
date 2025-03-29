package com.example.mugakusci.client.hal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record HalResponse(@JsonProperty("response") HalResponseBody body) {
}
