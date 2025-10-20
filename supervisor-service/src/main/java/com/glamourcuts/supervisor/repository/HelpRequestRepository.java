package com.glamourcuts.supervisor.repository;

import com.glamourcuts.supervisor.model.HelpRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelpRequestRepository extends MongoRepository<HelpRequest, Long> {
    List<HelpRequest> findByStatus(String status);
}