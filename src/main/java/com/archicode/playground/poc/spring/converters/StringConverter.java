package com.archicode.playground.poc.spring.converters;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.AttributeConverter;

/**
 * @author Tomasz Kozlowski (created on 03.05.2019)
 */
public class StringConverter implements AttributeConverter<StringProperty, String> {

    @Override
    public String convertToDatabaseColumn(StringProperty stringProperty) {
        return stringProperty.getValue();
    }

    @Override
    public StringProperty convertToEntityAttribute(String str) {
        return new SimpleStringProperty(str);
    }

}
