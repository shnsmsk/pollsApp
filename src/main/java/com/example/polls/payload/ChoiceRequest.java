package com.example.polls.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ChoiceRequest {
    @NotBlank
    @Size(max = 40)
    private String text;

    public ChoiceRequest() {
    }

    public ChoiceRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
