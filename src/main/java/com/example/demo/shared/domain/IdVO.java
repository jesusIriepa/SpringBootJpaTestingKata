package com.example.demo.shared.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;

import java.util.UUID;

public class IdVO {
    private final String value;

    public IdVO(String value) {
        this.guard(value);
        this.value = value;
    }

    private void guard(String requestValue) {
        if(requestValue == null) {
            throw new DomainArgumentException("text", "Null value is not allowed");
        }
        try {
            UUID.fromString(requestValue);
        } catch (Exception e) {
            throw new DomainArgumentException("Id", "Id format not allowed");
        }
    }

    public String getValue() {
        return value;
    }
}
