package com.github.voynova.bank.controller;

import com.github.voynova.bank.service.CardService;
import lombok.NonNull;

import java.util.UUID;

public class CardController {
    CardService service;

    public CardController() {
        this.service = new CardService();
    }

    public UUID getAuthorization(@NonNull String cardNumber, @NonNull String cardPin) {
        try {
            /* позвращаем токен клиенту - ResponseEntity.ok */
            return service.findCardId(cardNumber,cardPin);
        } catch (NullPointerException | IllegalStateException e) {
            /* позвращаем ошибку клиенту - ResponseEntity.notOk */
            System.out.println(e.getMessage());
        }
        //TODO так делать некрасиво
        return null;
    }

    public int getCardBalance (@NonNull UUID cardId) {
        return service.getCardBalanceById(cardId);
    }

}
