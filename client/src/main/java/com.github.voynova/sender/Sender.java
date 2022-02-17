package com.github.voynova.sender;

import org.springframework.stereotype.Component;

import java.util.UUID;


public interface Sender {
    int getCardBalance(UUID cardId);
    UUID getAuthorization(String number, String pin);
}
