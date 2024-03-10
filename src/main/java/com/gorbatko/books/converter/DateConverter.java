package com.gorbatko.books.converter;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateConverter extends AbstractBeanField<LocalDate, String> {
    private final DateTimeFormatter formatter;

    public DateConverter() {
        formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
    }

    @Override
    protected Object convert(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        try {
            return LocalDate.parse(value, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
