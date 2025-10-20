package com.glamourcuts.receptionist.service;

import com.glamourcuts.receptionist.model.KnowledgeBase;
import com.glamourcuts.receptionist.repository.KnowledgeBaseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private final KnowledgeBaseRepository knowledgeBaseRepository;
    
    public DataInitializer(KnowledgeBaseRepository knowledgeBaseRepository) {
        this.knowledgeBaseRepository = knowledgeBaseRepository;
    }
    
    @Override
    public void run(String... args) {
        if (knowledgeBaseRepository.count() == 0) {
            KnowledgeBase kb1 = new KnowledgeBase(); kb1.setQuestion("working hours"); kb1.setAnswer("We are open from 9am to 7pm."); knowledgeBaseRepository.save(kb1);
            KnowledgeBase kb2 = new KnowledgeBase(); kb2.setQuestion("hours"); kb2.setAnswer("We are open from 9am to 7pm."); knowledgeBaseRepository.save(kb2);
            KnowledgeBase kb3 = new KnowledgeBase(); kb3.setQuestion("services"); kb3.setAnswer("We offer Haircut, Hair Coloring, and Manicure."); knowledgeBaseRepository.save(kb3);
            KnowledgeBase kb4 = new KnowledgeBase(); kb4.setQuestion("haircut price"); kb4.setAnswer("Haircut costs $25."); knowledgeBaseRepository.save(kb4);
            KnowledgeBase kb5 = new KnowledgeBase(); kb5.setQuestion("hair coloring price"); kb5.setAnswer("Hair Coloring costs $50."); knowledgeBaseRepository.save(kb5);
            KnowledgeBase kb6 = new KnowledgeBase(); kb6.setQuestion("manicure price"); kb6.setAnswer("Manicure costs $20."); knowledgeBaseRepository.save(kb6);
            KnowledgeBase kb7 = new KnowledgeBase(); kb7.setQuestion("prices"); kb7.setAnswer("Haircut - $25, Hair Coloring - $50, Manicure - $20."); knowledgeBaseRepository.save(kb7);
            KnowledgeBase kb8 = new KnowledgeBase(); kb8.setQuestion("contact"); kb8.setAnswer("You can reach us at 123-456-7890."); knowledgeBaseRepository.save(kb8);
            KnowledgeBase kb9 = new KnowledgeBase(); kb9.setQuestion("phone"); kb9.setAnswer("You can reach us at 123-456-7890."); knowledgeBaseRepository.save(kb9);
        }
    }
}