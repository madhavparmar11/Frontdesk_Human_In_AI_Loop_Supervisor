package com.glamourcuts.receptionist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Random;

@Document(collection = "help_requests")
public class HelpRequest {
    @Id
    private Long id;
    
    private String customerName;
    private String question;
    private String status = "PENDING";
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public HelpRequest() {
        this.id = new Random().nextLong(1000000000L) + 1L; // 1-10 digit number
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}