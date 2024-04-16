package com.gmail.rixterd2.example;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class DataConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return attribute.toUpperCase();
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData.toLowerCase();
    }
}
