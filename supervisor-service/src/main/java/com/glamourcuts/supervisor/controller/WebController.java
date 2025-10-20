package com.glamourcuts.supervisor.controller;

import com.glamourcuts.supervisor.dto.ResolveRequest;
import com.glamourcuts.supervisor.service.SupervisorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    
    private final SupervisorService supervisorService;
    
    public WebController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }
    
    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("pendingRequests", supervisorService.getPendingRequests());
        model.addAttribute("allRequests", supervisorService.getAllRequests());
        return "dashboard";
    }
    
    @PostMapping("/resolve/{id}")
    public String resolveRequest(@PathVariable Long id, @RequestParam String answer) {
        ResolveRequest request = new ResolveRequest();
        request.setAnswer(answer);
        supervisorService.resolveRequest(id, request);
        return "redirect:/";
    }
}