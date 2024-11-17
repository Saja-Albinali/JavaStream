package com.example.suggestion.service;

import com.example.suggestion.SuggestionProcessor;
import com.example.suggestion.SuggestionStatus;
import com.example.suggestion.entity.GuestSuggestionEntity;
import com.example.suggestion.repository.GuestSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestSuggestionService {

    @Autowired
    private GuestSuggestionRepository guestSuggestionRepository;

    private final SuggestionProcessor processSuggestion = suggestionText -> {
        GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
        suggestionEntity.setSuggestionText(suggestionText);
        guestSuggestionRepository.save(suggestionEntity);
    };

    public void printAndProcessSuggestion(String suggestionText, Double rate) {
        System.out.println("processing suggestion: " + suggestionText);
        GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
        suggestionEntity.setSuggestionText(suggestionText);
        suggestionEntity.setRate(rate);
        guestSuggestionRepository.save(suggestionEntity);
    }
    public List<GuestSuggestionEntity> getAllSuggestions() {
        return guestSuggestionRepository.findAll();
    }

    public List<GuestSuggestionEntity> findAllCreatedSuggestions() {
        return guestSuggestionRepository.findAll()
                .stream()
                .filter(suggestion -> SuggestionStatus.CREATE.equals(suggestion.getStatus()))
                .collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> findAllRemovedSuggestions() {
        return guestSuggestionRepository.findAll()
                .stream()
                .filter(suggestion -> SuggestionStatus.REMOVE.equals(suggestion.getStatus()))
                .collect(Collectors.toList());
    }
}
