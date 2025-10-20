package com.glamourcuts.receptionist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Random;

@Document(collection = "knowledge_base")
public class KnowledgeBase {
    @Id
    private Long id;
    
    private String question;
    private String answer;
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public KnowledgeBase() {
        this.id = new Random().nextLong(1000000000L) + 1L; // 1-10 digit number
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
    
    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}