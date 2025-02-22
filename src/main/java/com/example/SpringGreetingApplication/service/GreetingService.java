package com.example.SpringGreetingApplication.service;

import com.example.SpringGreetingApplication.model.GreetingEntity;
import com.example.SpringGreetingApplication.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Generate a greeting, save it to the database, and return it
    public Map<String, String> getPersonalizedGreeting(String firstName, String lastName) {
        Map<String, String> response = new HashMap<>();
        String message;

        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World";
        }

        // Save message to database
        GreetingEntity greetingEntity = new GreetingEntity(message);
        GreetingEntity savedGreeting = greetingRepository.save(greetingEntity);

        response.put("id", String.valueOf(savedGreeting.getId())); // Return the saved ID
        response.put("message", message);
        return response;
    }

    // Retrieve a saved greeting by ID
    public Map<String, String> getGreetingById(Long id) {
        Map<String, String> response = new HashMap<>();
        Optional<GreetingEntity> greeting = greetingRepository.findById(id);

        if (greeting.isPresent()) {
            response.put("id", String.valueOf(greeting.get().getId()));
            response.put("message", greeting.get().getMessage());
        } else {
            response.put("error", "Greeting not found!");
        }

        return response;
    }
}
