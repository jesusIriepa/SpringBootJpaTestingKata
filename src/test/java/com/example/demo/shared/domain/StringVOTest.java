package com.example.demo.shared.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringVOTest {

    @Test
    void should_create_a_vo_ok() {
        String text = "Test text";
        StringVO stringVO = new StringVO(text);
        assertEquals(text, stringVO.getValue());
    }

    @Test
    void should_create_a_vo_with_size_ok() {
        String text = "Test text";
        StringVO stringVO = new StringVO(text, 2, 20);
        assertEquals(text, stringVO.getValue());
    }

    @Test
    void should_trows_domain_exception_null_value() {
        DomainArgumentException exception = assertThrows(DomainArgumentException.class,
            () -> new StringVO(null));
        assertTrue(exception.getCauseException().contains("Null value is not allowed"));
    }

    @Test
    void should_throws_domain_exception_max_size_validation() {
        String text = "Test text";
        Integer minSize = 2;
        Integer maxSize = text.length() - 1;
        DomainArgumentException exception = assertThrows(DomainArgumentException.class,
            () -> new StringVO(text, minSize, maxSize));
        assertTrue(exception.getCauseException().contains("Max size restriction"));
    }

    @Test
    void should_throws_domain_exception_min_size_validation() {
        String text = "Test text";
        Integer minSize = text.length() + 1;
        Integer maxSize = text.length() + 10;
        DomainArgumentException exception = assertThrows(DomainArgumentException.class,
            () -> new StringVO(text, minSize, maxSize));
        assertTrue(exception.getCauseException().contains("Min size restriction"));
    }

}