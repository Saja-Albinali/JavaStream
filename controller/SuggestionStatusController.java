package com.example.suggestion.controller;

import com.example.suggestion.entity.GuestSuggestionEntity;
import com.example.suggestion.service.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions/status")
public class SuggestionStatusController {

    @Autowired
    private GuestSuggestionService guestSuggestionService;

    @GetMapping("/created")
    public List<GuestSuggestionEntity>getCreatedSuggestions() {
        return guestSuggestionService.findAllCreatedSuggestions();
    }

    @GetMapping("/removed")
    public List<GuestSuggestionEntity>getRemovedSuggestions() {
        return guestSuggestionService.findAllRemovedSuggestions();
    }
}
