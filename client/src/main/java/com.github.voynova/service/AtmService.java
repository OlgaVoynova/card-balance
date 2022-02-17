package com.github.voynova.service;

import com.github.voynova.entity.Credentionals;
import com.github.voynova.sender.Sender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AtmService {
    private Sender sender;

    public int getCardBalance (UUID cardId) {

        return sender.getCardBalance(cardId);
    }

    public UUID getAuthorization (Credentionals credentionals) {
        return sender.getAuthorization(credentionals.getCardNumber(), credentionals.getCardPin());
    }
}
