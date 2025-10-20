package com.glamourcuts.supervisor.service;

import com.glamourcuts.supervisor.dto.ResolveRequest;
import com.glamourcuts.supervisor.model.HelpRequest;
import com.glamourcuts.supervisor.model.KnowledgeBase;
import com.glamourcuts.supervisor.repository.HelpRequestRepository;
import com.glamourcuts.supervisor.repository.KnowledgeBaseRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService {
    
    private final HelpRequestRepository helpRequestRepository;
    private final KnowledgeBaseRepository knowledgeBaseRepository;
    
    public SupervisorService(HelpRequestRepository helpRequestRepository, KnowledgeBaseRepository knowledgeBaseRepository) {
        this.helpRequestRepository = helpRequestRepository;
        this.knowledgeBaseRepository = knowledgeBaseRepository;
    }
    
    public List<HelpRequest> getPendingRequests() {
        return helpRequestRepository.findByStatus("PENDING");
    }
    
    public List<HelpRequest> getAllRequests() {
        return helpRequestRepository.findAll();
    }
    
    public boolean resolveRequest(Long requestId, ResolveRequest resolveRequest) {
        Optional<HelpRequest> helpRequestOpt = helpRequestRepository.findById(requestId);
        
        if (helpRequestOpt.isEmpty()) {
            return false;
        }
        
        HelpRequest helpRequest = helpRequestOpt.get();
        
        // Update help request status
        helpRequest.setStatus("RESOLVED");
        helpRequestRepository.save(helpRequest);
        
        // Add to knowledge base
        KnowledgeBase knowledge = new KnowledgeBase();
        knowledge.setQuestion(helpRequest.getQuestion());
        knowledge.setAnswer(resolveRequest.getAnswer());
        knowledgeBaseRepository.save(knowledge);
        
        // Simulate notification to AI Receptionist
        System.out.println("Customer " + helpRequest.getCustomerName() + ": " + resolveRequest.getAnswer());
        
        return true;
    }
}