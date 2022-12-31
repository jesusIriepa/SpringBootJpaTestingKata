package com.example.demo.shared.domain.exception;

import lombok.Getter;

@Getter
public class DomainArgumentException extends RuntimeException {
    private final String field;
    private final String causeException;

    public DomainArgumentException(String field, String causeException) {
        this.field = field;
        this.causeException = causeException;
    }
}
