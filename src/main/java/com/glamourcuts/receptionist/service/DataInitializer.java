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
        // Clear existing data and reload with new questions
        knowledgeBaseRepository.deleteAll();
        
        if (true) { // Always reload
            KnowledgeBase kb1 = new KnowledgeBase(); kb1.setQuestion("working hours"); kb1.setAnswer("We are open from 9am to 7pm."); knowledgeBaseRepository.save(kb1);
            KnowledgeBase kb2 = new KnowledgeBase(); kb2.setQuestion("hours"); kb2.setAnswer("We are open from 9am to 7pm."); knowledgeBaseRepository.save(kb2);
            KnowledgeBase kb3 = new KnowledgeBase(); kb3.setQuestion("services"); kb3.setAnswer("We offer Haircut, Hair Coloring, and Manicure."); knowledgeBaseRepository.save(kb3);
            KnowledgeBase kb4 = new KnowledgeBase(); kb4.setQuestion("haircut price"); kb4.setAnswer("Haircut costs $25."); knowledgeBaseRepository.save(kb4);
            KnowledgeBase kb5 = new KnowledgeBase(); kb5.setQuestion("hair coloring price"); kb5.setAnswer("Hair Coloring costs $50."); knowledgeBaseRepository.save(kb5);
            KnowledgeBase kb6 = new KnowledgeBase(); kb6.setQuestion("manicure price"); kb6.setAnswer("Manicure costs $20."); knowledgeBaseRepository.save(kb6);
            KnowledgeBase kb7 = new KnowledgeBase(); kb7.setQuestion("prices"); kb7.setAnswer("Haircut - $25, Hair Coloring - $50, Manicure - $20."); knowledgeBaseRepository.save(kb7);
            KnowledgeBase kb8 = new KnowledgeBase(); kb8.setQuestion("contact"); kb8.setAnswer("You can reach us at 123-456-7890."); knowledgeBaseRepository.save(kb8);
            KnowledgeBase kb9 = new KnowledgeBase(); kb9.setQuestion("phone"); kb9.setAnswer("You can reach us at 123-456-7890."); knowledgeBaseRepository.save(kb9);
            KnowledgeBase kb10 = new KnowledgeBase(); kb10.setQuestion("appointment"); kb10.setAnswer("To book an appointment, please call us at 123-456-7890 or visit us during business hours."); knowledgeBaseRepository.save(kb10);
            KnowledgeBase kb11 = new KnowledgeBase(); kb11.setQuestion("location"); kb11.setAnswer("We are located at 123 Beauty Street, Downtown. Easy parking available."); knowledgeBaseRepository.save(kb11);
            KnowledgeBase kb12 = new KnowledgeBase(); kb12.setQuestion("address"); kb12.setAnswer("Our address is 123 Beauty Street, Downtown. We're near the main shopping center."); knowledgeBaseRepository.save(kb12);
            KnowledgeBase kb13 = new KnowledgeBase(); kb13.setQuestion("pedicure"); kb13.setAnswer("Yes, we offer pedicure services for $30. Book your appointment today!"); knowledgeBaseRepository.save(kb13);
            KnowledgeBase kb14 = new KnowledgeBase(); kb14.setQuestion("walk-in"); kb14.setAnswer("We accept walk-ins based on availability, but appointments are recommended."); knowledgeBaseRepository.save(kb14);
            KnowledgeBase kb15 = new KnowledgeBase(); kb15.setQuestion("payment"); kb15.setAnswer("We accept cash, credit cards, and digital payments like Apple Pay and Google Pay."); knowledgeBaseRepository.save(kb15);
            KnowledgeBase kb16 = new KnowledgeBase(); kb16.setQuestion("staff"); kb16.setAnswer("Our experienced stylists have over 10 years of experience in hair and beauty services."); knowledgeBaseRepository.save(kb16);
            KnowledgeBase kb17 = new KnowledgeBase(); kb17.setQuestion("parking"); kb17.setAnswer("Free parking is available in front of our salon and in the adjacent lot."); knowledgeBaseRepository.save(kb17);
            KnowledgeBase kb18 = new KnowledgeBase(); kb18.setQuestion("closed"); kb18.setAnswer("We are closed on Sundays. Open Monday to Saturday, 9am to 7pm."); knowledgeBaseRepository.save(kb18);
            KnowledgeBase kb19 = new KnowledgeBase(); kb19.setQuestion("discount"); kb19.setAnswer("We offer 10% discount for students and seniors. First-time customers get 15% off!"); knowledgeBaseRepository.save(kb19);
            KnowledgeBase kb20 = new KnowledgeBase(); kb20.setQuestion("products"); kb20.setAnswer("We use premium hair care products from L'Oreal, Redken, and Matrix."); knowledgeBaseRepository.save(kb20);
            KnowledgeBase kb21 = new KnowledgeBase(); kb21.setQuestion("booking"); kb21.setAnswer("To book an appointment, please call us at 123-456-7890. We're open Monday to Saturday, 9am to 7pm."); knowledgeBaseRepository.save(kb21);
            KnowledgeBase kb22 = new KnowledgeBase(); kb22.setQuestion("schedule"); kb22.setAnswer("To schedule your visit, please call 123-456-7890. We'll find the perfect time for you!"); knowledgeBaseRepository.save(kb22);
            KnowledgeBase kb23 = new KnowledgeBase(); kb23.setQuestion("coming"); kb23.setAnswer("Great! To confirm your visit, please call us at 123-456-7890 to book your appointment."); knowledgeBaseRepository.save(kb23);
            KnowledgeBase kb24 = new KnowledgeBase(); kb24.setQuestion("visit"); kb24.setAnswer("We'd love to see you! Please call 123-456-7890 to schedule your appointment."); knowledgeBaseRepository.save(kb24);
            KnowledgeBase kb25 = new KnowledgeBase(); kb25.setQuestion("november"); kb25.setAnswer("Perfect timing! Please call us at 123-456-7890 to book your appointment for November."); knowledgeBaseRepository.save(kb25);
            KnowledgeBase kb26 = new KnowledgeBase(); kb26.setQuestion("hello"); kb26.setAnswer("Hello! Welcome to Glamour Cuts! How can I help you today?"); knowledgeBaseRepository.save(kb26);
            KnowledgeBase kb27 = new KnowledgeBase(); kb27.setQuestion("hi"); kb27.setAnswer("Hi there! Welcome to Glamour Cuts! What can I do for you?"); knowledgeBaseRepository.save(kb27);
            KnowledgeBase kb28 = new KnowledgeBase(); kb28.setQuestion("good morning"); kb28.setAnswer("Good morning! Welcome to Glamour Cuts! How may I assist you today?"); knowledgeBaseRepository.save(kb28);
            KnowledgeBase kb29 = new KnowledgeBase(); kb29.setQuestion("good afternoon"); kb29.setAnswer("Good afternoon! Welcome to Glamour Cuts! How can I help you?"); knowledgeBaseRepository.save(kb29);
            KnowledgeBase kb30 = new KnowledgeBase(); kb30.setQuestion("thanks"); kb30.setAnswer("You're welcome! Is there anything else I can help you with today?"); knowledgeBaseRepository.save(kb30);
            KnowledgeBase kb31 = new KnowledgeBase(); kb31.setQuestion("busy"); kb31.setAnswer("We can get quite busy, especially on weekends. I recommend calling ahead to book your appointment!"); knowledgeBaseRepository.save(kb31);
            KnowledgeBase kb32 = new KnowledgeBase(); kb32.setQuestion("wait time"); kb32.setAnswer("Wait times vary, but with an appointment you'll be seen right on time. Walk-ins may wait 15-30 minutes."); knowledgeBaseRepository.save(kb32);
            KnowledgeBase kb33 = new KnowledgeBase(); kb33.setQuestion("stylist"); kb33.setAnswer("Our stylists are highly trained professionals with 5-15 years of experience. You can request a specific stylist when booking."); knowledgeBaseRepository.save(kb33);
            KnowledgeBase kb34 = new KnowledgeBase(); kb34.setQuestion("hair wash"); kb34.setAnswer("Yes, all our services include a complimentary hair wash and conditioning treatment."); knowledgeBaseRepository.save(kb34);
            KnowledgeBase kb35 = new KnowledgeBase(); kb35.setQuestion("color consultation"); kb35.setAnswer("We offer free color consultations! Our stylists will help you choose the perfect shade for your skin tone."); knowledgeBaseRepository.save(kb35);
            KnowledgeBase kb36 = new KnowledgeBase(); kb36.setQuestion("group booking"); kb36.setAnswer("We love group bookings! For parties of 4 or more, please call us to arrange special scheduling and group discounts."); knowledgeBaseRepository.save(kb36);
            KnowledgeBase kb37 = new KnowledgeBase(); kb37.setQuestion("cancellation"); kb37.setAnswer("You can cancel or reschedule up to 2 hours before your appointment. Please call us at 123-456-7890."); knowledgeBaseRepository.save(kb37);
            KnowledgeBase kb38 = new KnowledgeBase(); kb38.setQuestion("gift card"); kb38.setAnswer("Yes! We offer gift cards in any amount. Perfect for birthdays, holidays, or special occasions!"); knowledgeBaseRepository.save(kb38);
            KnowledgeBase kb39 = new KnowledgeBase(); kb39.setQuestion("loyalty program"); kb39.setAnswer("Join our loyalty program! Get your 10th service free and earn points for discounts on products."); knowledgeBaseRepository.save(kb39);
            KnowledgeBase kb40 = new KnowledgeBase(); kb40.setQuestion("wedding"); kb40.setAnswer("We specialize in bridal hair and makeup! Book a trial session and we'll make your special day perfect."); knowledgeBaseRepository.save(kb40);
        }
    }
}