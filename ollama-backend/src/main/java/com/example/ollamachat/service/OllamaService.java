package com.example.ollamachat.service;

import com.example.ollamachat.model.ChatMessage;
import com.example.ollamachat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.boot.web.client.RestTemplateBuilder;
import reactor.core.publisher.Mono;
import org.json.JSONObject;
import java.time.Duration;

@Service
public class OllamaService {
    private final RestTemplate restTemplate;
    private final String ollamaUrl;

    public OllamaService(@Value("${ollama.url}") String ollamaUrl) {
        // Configure RestTemplate with longer timeouts
        this.restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(30))
                .setReadTimeout(Duration.ofMinutes(5))  // 5 minute read timeout
                .build();
                
        this.ollamaUrl = ollamaUrl;
        System.out.println("OllamaService initialized with URL: " + ollamaUrl);
    }

    public Mono<ChatResponse> sendToOllama(ChatMessage chatMessage) {
        return Mono.fromCallable(() -> {
            try {
                JSONObject body = new JSONObject();
                body.put("model", "llama2:latest");
                body.put("prompt", chatMessage.getPrompt());
                body.put("stream", false);

                System.out.println("Sending to Ollama with RestTemplate: " + body.toString());
                long startTime = System.currentTimeMillis();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

                String response = restTemplate.postForObject(ollamaUrl, request, String.class);
                
                long duration = System.currentTimeMillis() - startTime;
                System.out.println("Response received after " + duration + "ms");
                System.out.println("Response length: " + response.length());
                System.out.println("Response preview: " + response.substring(0, Math.min(300, response.length())) + "...");

                JSONObject json = new JSONObject(response);
                String answer = json.optString("response", "No response from Ollama");
                System.out.println("Extracted answer: " + answer.substring(0, Math.min(100, answer.length())) + "...");
                
                return new ChatResponse(answer.trim());

            } catch (Exception e) {
                System.out.println("RestTemplate error type: " + e.getClass().getSimpleName());
                System.out.println("RestTemplate error message: " + e.getMessage());
                e.printStackTrace();
                return new ChatResponse("Error: " + e.getMessage());
            }
        });
    }
}
