package com.example.SpringGreetingApplication.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {

    public Map<String, String> getGreeting(String method) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from " + method + " method");
        return response;
    }

    public Map<String, String> getSimpleGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello World");
        return response;
    }
}
