package com.example.suggestion.bo;

import com.example.suggestion.SuggestionStatus;

public class CreateSuggestionRequest {
    private Double rate;
    private String suggestionText;
    private SuggestionStatus status;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public SuggestionStatus getStatus() {
        return status;
    }

    public void setStatus(SuggestionStatus status) {
        this.status = status;
    }
}
