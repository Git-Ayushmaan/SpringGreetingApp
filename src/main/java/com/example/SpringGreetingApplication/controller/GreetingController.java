package com.example.SpringGreetingApplication.controller;

import com.example.SpringGreetingApplication.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Generate and save a greeting
    @GetMapping
    public Map<String, String> getGreet(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    // Retrieve a greeting by ID
    @GetMapping("/{id}")
    public Map<String, String> getGreetById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
}
