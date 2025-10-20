package com.glamourcuts.receptionist.controller;

import com.glamourcuts.receptionist.dto.QuestionRequest;
import com.glamourcuts.receptionist.service.ReceptionistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    
    private final ReceptionistService receptionistService;
    
    public WebController(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }
    
    @GetMapping("/")
    public String home() {
        return "customer";
    }
    
    @PostMapping("/ask")
    public String askQuestion(@RequestParam String customerName, 
                             @RequestParam String question, 
                             Model model) {
        QuestionRequest request = new QuestionRequest();
        request.setCustomerName(customerName);
        request.setQuestion(question);
        
        var response = receptionistService.processQuestion(request);
        
        model.addAttribute("customerName", customerName);
        model.addAttribute("question", question);
        model.addAttribute("answer", response.getAnswer());
        
        return "customer";
    }
}