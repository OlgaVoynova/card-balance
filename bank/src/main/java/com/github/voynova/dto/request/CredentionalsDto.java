package com.github.voynova.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public final class CredentionalsDto {
    private final String cardNumber;
    private final String cardPin;

    public CredentionalsDto(@JsonProperty("cardNumber") String cardNumber, @JsonProperty("cardPin") String cardPin) {
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
    }
}
