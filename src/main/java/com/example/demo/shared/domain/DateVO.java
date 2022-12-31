package com.example.demo.shared.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;

import java.time.LocalDate;

public class DateVO {
    private final LocalDate value;

    public DateVO(LocalDate value) {
        this.guard(value);
        this.value = value;
    }

    private void guard(LocalDate requestValue) {
        if(requestValue == null) {
            throw new DomainArgumentException("Date", "Null value is not allowed");
        }
    }

    public LocalDate getValue() {
        return value;
    }
}
