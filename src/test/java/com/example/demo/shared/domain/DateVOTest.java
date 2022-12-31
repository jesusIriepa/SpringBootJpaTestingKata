package com.example.demo.shared.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateVOTest {

    @Test
    void should_create_a_valid_datevo() {
        LocalDate localDate = LocalDate.now();
        DateVO dateVO = new DateVO(localDate);
        assertEquals(localDate, dateVO.getValue());
    }

    @Test
    void should_trows_domain_exception_null() {
        DomainArgumentException exception = assertThrows(DomainArgumentException.class,
            () -> new DateVO(null));
        assertTrue(exception.getCauseException().contains("Null value is not allowed"));
    }
}