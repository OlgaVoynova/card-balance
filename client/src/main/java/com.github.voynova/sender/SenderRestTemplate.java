package com.github.voynova.sender;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SenderRestTemplate implements Sender {
    @Override
    public int getCardBalance(UUID cardId) {
        return 0;
    }

    @Override
    public UUID getAuthorization(String number, String pin) {
        return null;
    }
}
