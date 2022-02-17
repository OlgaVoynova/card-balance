package com.github.voynova.sender;

import com.github.voynova.entity.Credentionals;
import com.github.voynova.entity.ResponseEnvelope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface Sender {
    int getCardBalance(UUID cardId);
    ResponseEnvelope getAuthorization(Credentionals credentionals);
}
