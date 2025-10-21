package com.glamourcuts.receptionist.config;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class VoiceWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Voice WebSocket connected: " + session.getId());
        session.sendMessage(new TextMessage("{\"type\":\"connected\",\"message\":\"Voice session ready\"}"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Received voice message: " + message.getPayload());
        // Echo back for now - in production this would handle audio streaming
        session.sendMessage(new TextMessage("{\"type\":\"echo\",\"data\":\"" + message.getPayload() + "\"}"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Voice WebSocket disconnected: " + session.getId());
    }
}