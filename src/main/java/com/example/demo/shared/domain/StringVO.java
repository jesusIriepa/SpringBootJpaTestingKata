package com.example.demo.shared.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;

public class StringVO {
    private final String value;

    public StringVO(String value) {
        this.guard(value);
        this.value = value;
    }

    public StringVO(String value, Integer minSize, Integer maxSize) {
        this.guard(value, minSize, maxSize);
        this.value = value;
    }

    private void guard(String requestValue) {
        if(requestValue == null) {
            throw new DomainArgumentException("text", "Null value is not allowed");
        }
    }

    private void guard(String requestValue, Integer minSize, Integer maxSize) {
        this.guard(requestValue);
        if(minSize != null && requestValue.length() < minSize) {
            throw new DomainArgumentException("text", "Min size restriction");
        }
        if(maxSize != null && requestValue.length() > maxSize) {
            throw new DomainArgumentException("text", "Max size restriction");
        }
    }

    public String getValue() {
        return value;
    }
}
