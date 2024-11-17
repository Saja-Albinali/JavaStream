package com.example.suggestion.controller;

import com.example.suggestion.bo.CreateSuggestionRequest;
import com.example.suggestion.entity.GuestSuggestionEntity;
import com.example.suggestion.service.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    @Autowired
    private GuestSuggestionService guestSuggestionService;

    @PostMapping
    public ResponseEntity<String>processSuggestion(@RequestBody CreateSuggestionRequest request) {
        guestSuggestionService.printAndProcessSuggestion(request.getSuggestionText(), request.getRate());
        return new ResponseEntity<>("processed successful", HttpStatus.OK);
    }
    @GetMapping
    public List<GuestSuggestionEntity>getAllSuggestions() {
        return guestSuggestionService.getAllSuggestions();
    }
}
