package com.glamourcuts.supervisor.repository;

import com.glamourcuts.supervisor.model.KnowledgeBase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeBaseRepository extends MongoRepository<KnowledgeBase, Long> {
}