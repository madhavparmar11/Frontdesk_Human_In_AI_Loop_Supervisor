package com.glamourcuts.supervisor.controller;

import com.glamourcuts.supervisor.dto.ResolveRequest;
import com.glamourcuts.supervisor.model.HelpRequest;
import com.glamourcuts.supervisor.service.SupervisorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class SupervisorController {
    
    private final SupervisorService supervisorService;
    
    public SupervisorController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }
    
    @GetMapping("/pending")
    public ResponseEntity<List<HelpRequest>> getPendingRequests() {
        List<HelpRequest> requests = supervisorService.getPendingRequests();
        return ResponseEntity.ok(requests);
    }
    
    @GetMapping("/history")
    public ResponseEntity<List<HelpRequest>> getRequestHistory() {
        List<HelpRequest> requests = supervisorService.getAllRequests();
        return ResponseEntity.ok(requests);
    }
    
    @PostMapping("/{id}/resolve")
    public ResponseEntity<String> resolveRequest(@PathVariable Long id, @RequestBody ResolveRequest request) {
        boolean resolved = supervisorService.resolveRequest(id, request);
        
        if (resolved) {
            return ResponseEntity.ok("Request resolved successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}