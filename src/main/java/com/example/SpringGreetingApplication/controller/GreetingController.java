package com.example.SpringGreetingApplication.controller;

import com.example.SpringGreetingApplication.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor Injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET method to return a greeting message
    @GetMapping
    public Map<String, String> getGreet() {
        return greetingService.getGreeting("GET");
    }

    // POST method to return a greeting message
    @PostMapping
    public Map<String, String> postGreet() {
        return greetingService.getGreeting("POST");
    }

    // PUT method to return a greeting message
    @PutMapping
    public Map<String, String> putGreet() {
        return greetingService.getGreeting("PUT");
    }

    // DELETE method to return a greeting message
    @DeleteMapping
    public Map<String, String> deleteGreet() {
        return greetingService.getGreeting("DELETE");
    }

    // New endpoint for simple greeting "Hello World"
    @GetMapping("/simple")
    public Map<String, String> getSimpleGreeting() {
        return greetingService.getSimpleGreeting();
    }
}
