package com.glamourcuts.receptionist.controller;

import com.glamourcuts.receptionist.dto.AnswerResponse;
import com.glamourcuts.receptionist.dto.QuestionRequest;
import com.glamourcuts.receptionist.service.ReceptionistService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/voice")
@RequiredArgsConstructor
public class VoiceController {

    @Value("${livekit.api.key}")
    private String apiKey;

    @Value("${livekit.api.secret}")
    private String apiSecret;

    @Value("${livekit.ws.url}")
    private String wsUrl;

    private final ReceptionistService receptionistService;

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> getToken(@RequestBody Map<String, String> request) {
        String customerName = request.get("customerName");
        String roomName = "voice-session-" + System.currentTimeMillis();
        
        String token = generateLiveKitToken(customerName, roomName);

        return ResponseEntity.ok(Map.of(
            "token", token,
            "wsUrl", wsUrl,
            "roomName", roomName
        ));
    }
    
    private String generateLiveKitToken(String identity, String roomName) {
        return io.jsonwebtoken.Jwts.builder()
            .setIssuer(apiKey)
            .setSubject(identity)
            .claim("video", Map.of("room", roomName, "roomJoin", true))
            .setExpiration(new java.util.Date(System.currentTimeMillis() + 3600000))
            .signWith(io.jsonwebtoken.security.Keys.hmacShaKeyFor(apiSecret.getBytes()))
            .compact();
    }

    @PostMapping("/process-speech")
    public ResponseEntity<Map<String, String>> processSpeech(@RequestBody Map<String, String> request) {
        String customerName = request.get("customerName");
        String transcript = request.get("transcript");

        QuestionRequest questionRequest = new QuestionRequest();
        questionRequest.setCustomerName(customerName);
        questionRequest.setQuestion(transcript);
        
        // Check if email is provided
        String customerEmail = request.get("customerEmail");
        if (customerEmail != null) {
            questionRequest.setCustomerEmail(customerEmail);
        }
        
        AnswerResponse response = receptionistService.processQuestion(questionRequest);
        
        return ResponseEntity.ok(Map.of("answer", response.getAnswer()));
    }
}