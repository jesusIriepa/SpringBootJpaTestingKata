package com.example.demo.subject.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject/{idSubject}/class")
public class SubjectClassController {

    @GetMapping
    public ResponseEntity<Void> getAll() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createClass(@PathVariable String idSubject) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idClass}")
    public ResponseEntity<Void> updateClass(@PathVariable String idSubject, @PathVariable String idClass) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idClass}/cancel")
    public ResponseEntity<Void> cancelClass(@PathVariable String idSubject, @PathVariable String idClass) {
        return ResponseEntity.ok().build();
    }
}
