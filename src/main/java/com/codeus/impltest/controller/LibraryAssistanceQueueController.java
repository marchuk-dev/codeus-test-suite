package com.codeus.impltest.controller;

import com.codeus.impltest.entity.LibraryAssistanceQueueEntity;
import com.codeus.impltest.service.LibraryAssistanceQueueService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/queues")
@RequiredArgsConstructor
public class LibraryAssistanceQueueController {

    private final LibraryAssistanceQueueService service;

    @GetMapping
    public ResponseEntity<List<LibraryAssistanceQueueEntity>> getAllQueues() {
        return ResponseEntity.ok(service.getAllQueues());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryAssistanceQueueEntity> getQueueById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getQueueById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryAssistanceQueueEntity> createQueue(@RequestBody LibraryAssistanceQueueEntity queue) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createQueue(queue));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryAssistanceQueueEntity> updateQueue(
            @PathVariable Long id,
            @RequestBody LibraryAssistanceQueueEntity updatedQueue) {
        return ResponseEntity.ok(service.updateQueue(id, updatedQueue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQueue(@PathVariable Long id) {
        service.deleteQueue(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
