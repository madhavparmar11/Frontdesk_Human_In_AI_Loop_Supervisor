package com.glamourcuts.supervisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendQueryResolvedEmail(String customerEmail, String customerName, String question, String answer) {
        if (customerEmail == null || customerEmail.trim().isEmpty()) {
            System.out.println("No email provided for customer: " + customerName);
            return;
        }
        
        try {
            System.out.println("Attempting to send email to: " + customerEmail);
            
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(customerEmail);
            message.setSubject("Your Query Has Been Resolved - Glamour Cuts");
            message.setText(
                "Dear " + customerName + ",\n\n" +
                "Thank you for contacting Glamour Cuts! Your query has been resolved.\n\n" +
                "Your Question: " + question + "\n\n" +
                "Our Response: " + answer + "\n\n" +
                "If you have any other questions, feel free to contact us at 123-456-7890.\n\n" +
                "Best regards,\n" +
                "Glamour Cuts Team"
            );
            message.setFrom("raghavparmar2004@gmail.com");
            
            mailSender.send(message);
            System.out.println("✅ Email sent successfully to: " + customerEmail);
        } catch (Exception e) {
            System.err.println("❌ Gmail Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Root cause: " + e.getCause().getMessage());
            }
            System.out.println("\n📧 EMAIL CONTENT (Gmail delivery failed):");
            System.out.println("\n=== EMAIL NOTIFICATION ===");
            System.out.println("To: " + customerEmail);
            System.out.println("Subject: Your Query Has Been Resolved - Glamour Cuts");
            System.out.println("Message:");
            System.out.println("Dear " + customerName + ",\n");
            System.out.println("Thank you for contacting Glamour Cuts! Your query has been resolved.\n");
            System.out.println("Your Question: " + question + "\n");
            System.out.println("Our Response: " + answer + "\n");
            System.out.println("If you have any other questions, feel free to contact us at 123-456-7890.\n");
            System.out.println("Best regards,\nGlamour Cuts Team");
            System.out.println("========================\n");
        }
    }
}