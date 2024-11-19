package com.codeus.impltest.service;

import com.codeus.impltest.entity.LibraryAssistanceQueueEntity;
import com.codeus.impltest.repo.LibraryAssistanceQueueRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryAssistanceQueueService {

    private final LibraryAssistanceQueueRepository repository;

    public List<LibraryAssistanceQueueEntity> getAllQueues() {
        return repository.findAll();
    }

    public LibraryAssistanceQueueEntity getQueueById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Queue with ID " + id + " not found"));
    }

    public LibraryAssistanceQueueEntity createQueue(LibraryAssistanceQueueEntity queue) {
        if (repository.findByQueueName(queue.getQueueName()).isPresent()) {
            throw new IllegalArgumentException("Queue with name " + queue.getQueueName() + " already exists");
        }
        return repository.save(queue);
    }

    public LibraryAssistanceQueueEntity updateQueue(Long id, LibraryAssistanceQueueEntity updatedQueue) {
        LibraryAssistanceQueueEntity existingQueue = getQueueById(id);
        existingQueue.setQueueName(updatedQueue.getQueueName());
        existingQueue.setDescription(updatedQueue.getDescription());
        existingQueue.setBookGenres(updatedQueue.getBookGenres());
        existingQueue.setInquiryTypes(updatedQueue.getInquiryTypes());
        return repository.save(existingQueue);
    }

    public void deleteQueue(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Queue with ID " + id + " not found");
        }
        repository.deleteById(id);
    }
}
