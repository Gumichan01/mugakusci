package com.example.mugakusci.client.theses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ThesesAuthor(@JsonProperty("nom") String lastName,
                           @JsonProperty("prenom") String firstName) {
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
