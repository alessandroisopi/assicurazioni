package it.onyx.assicurazioni.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE;
    @Override
    public LocalDateTime unmarshal(String s) throws Exception {
        if (s == null || s.isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(s, FORMATTER);
    }

    @Override
    public String marshal(LocalDateTime localDateTime) throws Exception {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(FORMATTER);
    }
}
