package com.github.voynova.controller;

import com.github.voynova.service.CardService;
import lombok.NonNull;

import java.util.UUID;

public class CardController {
    private CardService service;

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
