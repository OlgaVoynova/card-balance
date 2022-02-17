package com.github.voynova.service;

import com.github.voynova.entity.Credentionals;
import com.github.voynova.entity.ResponseEnvelope;
import com.github.voynova.sender.Sender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AtmService {
    private Sender sender;

    public int getCardBalance (UUID cardId) {
        return sender.getCardBalance(cardId);
    }

    public ResponseEnvelope getAuthorization (Credentionals credentionals) {
        return sender.getAuthorization(credentionals);
    }
}
