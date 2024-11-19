package com.codeus.impltest.repo;

import com.codeus.impltest.entity.LibraryAssistanceQueueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryAssistanceQueueRepository extends JpaRepository<LibraryAssistanceQueueEntity, Long> {
    Optional<LibraryAssistanceQueueEntity> findByQueueName(String queueName);
}
