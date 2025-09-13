package com.example.ollamachat.controller;

import com.example.ollamachat.model.ChatMessage;
import com.example.ollamachat.model.ChatResponse;
import com.example.ollamachat.service.OllamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/chat")
public class ChatController {
    
    @Autowired
    private OllamaService ollamaService;

    @PostMapping
    public DeferredResult<ChatResponse> chat(@RequestBody ChatMessage message) {
        DeferredResult<ChatResponse> deferredResult = new DeferredResult<>(300000L); // 5 minutes
        
        System.out.println("Received message: " + message.getPrompt());
        
        ollamaService.sendToOllama(message)
            .subscribe(
                response -> {
                    System.out.println("Sending response to client: " + response.getMessage().substring(0, Math.min(50, response.getMessage().length())) + "...");
                    deferredResult.setResult(response);
                },
                error -> {
                    System.out.println("Error occurred: " + error.getMessage());
                    deferredResult.setErrorResult(new ChatResponse("Error: " + error.getMessage()));
                }
            );
            
        return deferredResult;
    }
}
