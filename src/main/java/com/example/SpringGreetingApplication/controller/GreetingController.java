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

    // GET method to return a personalized greeting
    @GetMapping
    public Map<String, String> getGreet(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    // POST method for a personalized greeting
    @PostMapping
    public Map<String, String> postGreet(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    // PUT method for a personalized greeting
    @PutMapping
    public Map<String, String> putGreet(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    // DELETE method for a personalized greeting
    @DeleteMapping
    public Map<String, String> deleteGreet(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }
}
