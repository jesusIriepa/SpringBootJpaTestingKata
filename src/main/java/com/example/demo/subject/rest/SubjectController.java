package com.example.demo.subject.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @PostMapping
    public ResponseEntity<Void> create() {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update() {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete() {
        return ResponseEntity.ok().build();
    }
}
