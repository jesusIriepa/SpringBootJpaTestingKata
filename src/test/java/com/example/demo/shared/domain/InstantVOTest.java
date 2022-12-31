package com.example.demo.shared.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InstantVOTest {

    @Test
    void should_create_a_instantvo_ok() {
        Instant instant = Instant.now();
        InstantVO instantVO = new InstantVO(instant);
        assertEquals(instant, instantVO.getValue());
    }

    @Test
    void should_throws_domain_exception_null() {
        DomainArgumentException exception = assertThrows(DomainArgumentException.class, () -> new InstantVO(null));
        assertTrue(exception.getCauseException().contains("Null value is not allowed"));
    }
}