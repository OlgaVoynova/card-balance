package com.github.voynova.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Credentionals {
    private String cardNumber;
    private String cardPin;

    public Credentionals(@JsonProperty("cardNumber") String cardNumber,
                         @JsonProperty("cardPin") String cardPin) {
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
    }
}
