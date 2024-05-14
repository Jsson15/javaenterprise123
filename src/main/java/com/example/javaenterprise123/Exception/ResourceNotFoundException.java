package com.example.javaenterprise123.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Anpassad undantagsklass som representerar ett situation när en resurs inte hittas
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    // Konstruktor som skapar ett undantag med detaljerad felmeddelande baserat på saknade resursens namn, fält och värde
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    // Getter för resursens namn
    public String getResourceName() {
        return resourceName;
    }

    // Getter för fältets namn
    public String getFieldName() {
        return fieldName;
    }

    // Getter för fältets värde
    public Object getFieldValue() {
        return fieldValue;
    }
}
