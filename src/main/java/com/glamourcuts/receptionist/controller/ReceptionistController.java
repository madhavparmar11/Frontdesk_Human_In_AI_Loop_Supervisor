package com.glamourcuts.receptionist.controller;

import com.glamourcuts.receptionist.dto.AnswerResponse;
import com.glamourcuts.receptionist.dto.QuestionRequest;
import com.glamourcuts.receptionist.service.ReceptionistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReceptionistController {
    
    private final ReceptionistService receptionistService;
    
    public ReceptionistController(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }
    
    @PostMapping("/ask")
    public ResponseEntity<AnswerResponse> askQuestion(@RequestBody QuestionRequest request) {
        AnswerResponse response = receptionistService.processQuestion(request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/knowledge/{question}")
    public ResponseEntity<AnswerResponse> getKnowledge(@PathVariable String question) {
        return receptionistService.getKnowledgeAnswer(question)
                .map(answer -> ResponseEntity.ok(new AnswerResponse(answer)))
                .orElse(ResponseEntity.notFound().build());
    }
}