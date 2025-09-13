package com.example.ollamachat.model;

public class ChatMessage {
    private String prompt;
    private String model = "llama3"; // default model, can be changed by UI

    public String getPrompt() { return prompt; }
    public void setPrompt(String prompt) { this.prompt = prompt; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
}
