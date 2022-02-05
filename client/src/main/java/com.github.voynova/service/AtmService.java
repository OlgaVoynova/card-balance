package com.github.voynova.client.service;

import com.github.voynova.controller.CardController;
import com.github.voynova.client.entity.Credentionals;

import java.util.UUID;

public class AtmService {
    private CardController cardController;

    public AtmService () {
        this.cardController = new CardController();
    }

    public int getCardBalance (UUID cardId) {
        return cardController.getCardBalance(cardId);
    }

    public UUID getAuthorization (Credentionals credentionals) {
        return cardController.getAuthorization(credentionals.getCardNumber(), credentionals.getCardPin());
    }
}
