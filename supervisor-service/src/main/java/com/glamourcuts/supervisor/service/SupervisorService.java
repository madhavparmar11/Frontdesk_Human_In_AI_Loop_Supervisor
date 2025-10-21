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
    private final EmailService emailService;
    
    public SupervisorService(HelpRequestRepository helpRequestRepository, KnowledgeBaseRepository knowledgeBaseRepository, EmailService emailService) {
        this.helpRequestRepository = helpRequestRepository;
        this.knowledgeBaseRepository = knowledgeBaseRepository;
        this.emailService = emailService;
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
        
        // Update help request with manager response
        helpRequest.setStatus("RESOLVED");
        helpRequest.setManagerResponse(resolveRequest.getAnswer());
        helpRequest.setResolvedAt(java.time.LocalDateTime.now());
        helpRequestRepository.save(helpRequest);
        
        // Add to knowledge base for keyword matching
        KnowledgeBase knowledge = new KnowledgeBase();
        knowledge.setQuestion(helpRequest.getQuestion());
        knowledge.setAnswer(resolveRequest.getAnswer());
        knowledgeBaseRepository.save(knowledge);
        
        // Send email notification to customer
        System.out.println("Customer email: " + helpRequest.getCustomerEmail());
        if (helpRequest.getCustomerEmail() != null && !helpRequest.getCustomerEmail().isEmpty()) {
            System.out.println("Sending email notification to: " + helpRequest.getCustomerEmail());
            emailService.sendQueryResolvedEmail(
                helpRequest.getCustomerEmail(),
                helpRequest.getCustomerName(),
                helpRequest.getQuestion(),
                resolveRequest.getAnswer()
            );
        } else {
            System.out.println("No email provided for customer: " + helpRequest.getCustomerName());
        }
        
        System.out.println("Query resolved and customer notified: " + helpRequest.getCustomerName());
        
        return true;
    }
}