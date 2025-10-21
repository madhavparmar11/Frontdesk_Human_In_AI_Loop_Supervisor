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
        String question = request.getQuestion().toLowerCase();
        
        // First check knowledge base with exact keyword matching
        Optional<KnowledgeBase> knowledge = knowledgeBaseRepository.findAll().stream()
            .filter(kb -> {
                String kbQuestion = kb.getQuestion().toLowerCase();
                String extractedKeyword = extractKeywords(question);
                
                // Only exact matches or very specific keyword matches
                return question.contains(kbQuestion) || kbQuestion.contains(question.replace("do you ", "").replace("what ", ""));
            })
            .findFirst();
        
        if (knowledge.isPresent()) {
            return new AnswerResponse(knowledge.get().getAnswer());
        }
        
        // Check if manager has already answered similar question
        Optional<HelpRequest> resolvedRequest = helpRequestRepository.findAll().stream()
            .filter(hr -> "RESOLVED".equals(hr.getStatus()) && 
                         hr.getManagerResponse() != null &&
                         questionsSimilar(hr.getQuestion().toLowerCase(), question))
            .findFirst();
            
        if (resolvedRequest.isPresent()) {
            return new AnswerResponse(resolvedRequest.get().getManagerResponse());
        }
        
        // Save new help request for unknown questions
        HelpRequest helpRequest = new HelpRequest();
        helpRequest.setCustomerName(request.getCustomerName());
        helpRequest.setCustomerEmail(request.getCustomerEmail());
        helpRequest.setQuestion(request.getQuestion());
        helpRequestRepository.save(helpRequest);
        
        return new AnswerResponse(UNKNOWN_ANSWER);
    }
    
    private boolean questionsSimilar(String q1, String q2) {
        String[] words1 = q1.split("\\s+");
        String[] words2 = q2.split("\\s+");
        
        for (String word1 : words1) {
            for (String word2 : words2) {
                if (word1.length() > 3 && word2.length() > 3 && 
                    (word1.contains(word2) || word2.contains(word1))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private String extractKeywords(String question) {
        if (question.contains("hour") || question.contains("time") || question.contains("open")) return "hours";
        if (question.equals("services") || question.equals("what services")) return "services";
        if (question.contains("price") || question.contains("cost") || question.contains("much")) return "price";
        if (question.contains("contact") || question.contains("phone") || question.contains("number")) return "contact";
        if (question.contains("appointment") || question.contains("book") || question.contains("schedule")) return "appointment";
        if (question.contains("location") || question.contains("where") || question.contains("address")) return "location";
        if (question.contains("pedicure") || question.contains("foot")) return "pedicure";
        if (question.contains("walk") || question.contains("without appointment")) return "walk-in";
        if (question.contains("payment") || question.contains("pay") || question.contains("card")) return "payment";
        if (question.contains("staff") || question.contains("stylist") || question.contains("experience")) return "staff";
        if (question.contains("parking") || question.contains("park")) return "parking";
        if (question.contains("closed") || question.contains("sunday")) return "closed";
        if (question.contains("discount") || question.contains("deal") || (question.contains("offer") && question.contains("discount"))) return "discount";
        if (question.contains("product") || question.contains("brand")) return "products";
        if (question.contains("book") || question.contains("booking") || question.contains("reserve")) return "booking";
        if (question.contains("schedule") || question.contains("time") || question.contains("date")) return "schedule";
        if (question.contains("coming") || question.contains("visit") || question.contains("see you")) return "coming";
        if (question.contains("november") || question.contains("december") || question.contains("january")) return "november";
        if (question.contains("hello") || question.contains("hey")) return "hello";
        if (question.contains("hi") || question.contains("hai")) return "hi";
        if (question.contains("good morning") || question.contains("morning")) return "good morning";
        if (question.contains("good afternoon") || question.contains("afternoon")) return "good afternoon";
        if (question.contains("thank") || question.contains("thanks")) return "thanks";
        if (question.contains("busy") || question.contains("crowded")) return "busy";
        if (question.contains("wait") || question.contains("long")) return "wait time";
        if (question.contains("stylist") || question.contains("hairdresser")) return "stylist";
        if (question.contains("wash") || question.contains("shampoo")) return "hair wash";
        if (question.contains("consultation") || question.contains("advice")) return "color consultation";
        if (question.contains("group") || question.contains("party")) return "group booking";
        if (question.contains("cancel") || question.contains("reschedule")) return "cancellation";
        if (question.contains("gift") || question.contains("voucher")) return "gift card";
        if (question.contains("loyalty") || question.contains("reward")) return "loyalty program";
        if (question.contains("wedding") || question.contains("bridal")) return "wedding";
        return question;
    }
    
    public Optional<String> getKnowledgeAnswer(String question) {
        return knowledgeBaseRepository.findFirstByQuestionContainingIgnoreCase(question)
                .map(KnowledgeBase::getAnswer);
    }
}