package com.glamourcuts.receptionist.service;

import com.glamourcuts.receptionist.dto.AnswerResponse;
import com.glamourcuts.receptionist.dto.QuestionRequest;
import com.glamourcuts.receptionist.model.HelpRequest;
import com.glamourcuts.receptionist.model.KnowledgeBase;
import com.glamourcuts.receptionist.repository.HelpRequestRepository;
import com.glamourcuts.receptionist.repository.KnowledgeBaseRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReceptionistService {
    
    private final KnowledgeBaseRepository knowledgeBaseRepository;
    private final HelpRequestRepository helpRequestRepository;
    
    public ReceptionistService(KnowledgeBaseRepository knowledgeBaseRepository, HelpRequestRepository helpRequestRepository) {
        this.knowledgeBaseRepository = knowledgeBaseRepository;
        this.helpRequestRepository = helpRequestRepository;
    }
    
    private static final String UNKNOWN_ANSWER = "Let me check with my supervisor and get back to you.";
    
    public AnswerResponse processQuestion(QuestionRequest request) {
        Optional<KnowledgeBase> knowledge = knowledgeBaseRepository.findFirstByQuestionContainingIgnoreCase(request.getQuestion());
        
        if (knowledge.isPresent()) {
            return new AnswerResponse(knowledge.get().getAnswer());
        }
        
        // Save help request for unknown questions
        HelpRequest helpRequest = new HelpRequest();
        helpRequest.setCustomerName(request.getCustomerName());
        helpRequest.setQuestion(request.getQuestion());
        helpRequestRepository.save(helpRequest);
        
        return new AnswerResponse(UNKNOWN_ANSWER);
    }
    
    public Optional<String> getKnowledgeAnswer(String question) {
        return knowledgeBaseRepository.findFirstByQuestionContainingIgnoreCase(question)
                .map(KnowledgeBase::getAnswer);
    }
}