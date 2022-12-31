package com.example.demo.shared.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;

import java.time.Instant;

public class InstantVO {

    private final Instant value;

    public InstantVO(Instant value) {
        this.guard(value);
        this.value = value;
    }

    private void guard(Instant requestValue) {
        if(requestValue == null) {
            throw new DomainArgumentException("text", "Null value is not allowed");
        }
    }

    public Instant getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
