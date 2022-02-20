package com.github.voynova.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public final class CredentialsDto {
    private final String cardNumber;
    private final String cardPin;

    public CredentialsDto(@JsonProperty("cardNumber") String cardNumber, @JsonProperty("cardPin") String cardPin) {
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
    }
}
