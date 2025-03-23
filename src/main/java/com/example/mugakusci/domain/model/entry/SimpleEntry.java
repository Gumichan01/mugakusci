package com.example.mugakusci.domain.model.entry;

public record SimpleEntry(String label, String url) implements IEntry {
    @Override
    public String link() {
        return url;
    }
}
