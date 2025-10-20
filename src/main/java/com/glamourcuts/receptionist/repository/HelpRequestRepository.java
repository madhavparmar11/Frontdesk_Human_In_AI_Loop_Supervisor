package com.glamourcuts.receptionist.repository;

import com.glamourcuts.receptionist.model.HelpRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRequestRepository extends MongoRepository<HelpRequest, Long> {
}