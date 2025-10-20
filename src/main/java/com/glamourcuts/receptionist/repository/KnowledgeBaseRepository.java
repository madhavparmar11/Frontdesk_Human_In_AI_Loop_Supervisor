package com.glamourcuts.receptionist.repository;

import com.glamourcuts.receptionist.model.KnowledgeBase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KnowledgeBaseRepository extends MongoRepository<KnowledgeBase, Long> {
    Optional<KnowledgeBase> findFirstByQuestionContainingIgnoreCase(String question);
}