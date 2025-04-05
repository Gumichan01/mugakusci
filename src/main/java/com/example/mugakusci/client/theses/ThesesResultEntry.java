package com.example.mugakusci.client.theses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ThesesResultEntry(@JsonProperty("id") String id,
                                @JsonProperty("titrePrincipal") String title,
                                @JsonProperty("auteurs") List<ThesesAuthor> authors,
                                @JsonProperty("status") String status,
                                @JsonProperty("dateSoutenance") String dateTxt) {

    private Date parseDate(String pattern, String dateTxt) {
        try {
            return new SimpleDateFormat(pattern).parse(dateTxt);
        } catch (ParseException ignored) {
            System.err.println("Cannot parse date from text");
            return null;
        }
    }

    public String label() {
        var originalPattern = "dd/MM/yyyy";
        var iso8601Pattern = "yyyy-MM-dd";
        Date date = parseDate(originalPattern, dateTxt);
        String formattedDate = (date != null ? new SimpleDateFormat(iso8601Pattern).format(date) : "");
        return authors + ". " + title + ". " + formattedDate;
    }

    public boolean isPresented() {
        return status.equalsIgnoreCase("soutenue");
    }

    public String link() {
        return "https://www.theses.fr/$id";
    }
}
