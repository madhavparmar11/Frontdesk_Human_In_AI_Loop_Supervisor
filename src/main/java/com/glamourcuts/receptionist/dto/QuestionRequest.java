package com.glamourcuts.receptionist.dto;

public class QuestionRequest {
    private String customerName;
    private String question;
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
}