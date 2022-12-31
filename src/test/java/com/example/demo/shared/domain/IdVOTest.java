package com.example.demo.shared.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdVOTest {

    @Test
    void should_create_a_idvo_ok() {
        String id = UUID.randomUUID().toString();
        IdVO idVO = new IdVO(id);
        assertEquals(id, idVO.getValue());
    }

    @Test
    void should_trows_domain_exception_null() {
        DomainArgumentException exception = assertThrows(DomainArgumentException.class,
            () -> new IdVO(null));
        assertTrue(exception.getCauseException().contains("Null value is not allowed"));
    }

    @Test
    void should_trows_domain_exception_bad_format() {
        DomainArgumentException exception = assertThrows(DomainArgumentException.class,
            () -> new IdVO("bad-format"));
        assertTrue(exception.getCauseException().contains("Id format not allowed"));
    }
}