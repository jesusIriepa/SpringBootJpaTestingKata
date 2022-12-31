package com.example.demo.teacher.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;
import org.apache.commons.lang3.EnumUtils;

public class TeacherStatus {
    private final String value;

    public TeacherStatus(Status value) {
        this.value = value.name();
    }
    public TeacherStatus(String value) {
        this.guard(value);
        this.value = value;
    }

    private void guard(String requestValue) {
        if(requestValue == null) {
            throw new DomainArgumentException("Teacher Status", "Null value is not allowed");
        }
        if(!EnumUtils.isValidEnum(Status.class, requestValue)) {
            throw new DomainArgumentException("Teacher Status", requestValue + " is not a valid Status");
        }
    }

    public String getValue() {
        return value;
    }

    public enum Status {
        CREATED,
        ACTIVE,
        INACTIVE
    }
}
