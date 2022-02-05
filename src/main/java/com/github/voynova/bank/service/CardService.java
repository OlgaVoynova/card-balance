package com.github.voynova.bank.service;

import com.github.voynova.bank.entity.CardEntity;
import com.github.voynova.bank.repository.CardRepository;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class CardService {

    CardRepository repository;

    public CardService() {
        this.repository = new CardRepository();
    }
    public int getCardBalanceById (@NonNull UUID cardId) {
        return repository.findCardById(cardId).get().getBalance();
    }

    public UUID findCardId (@NonNull String cardNumber, @NonNull String pin) {
        Optional<CardEntity> cardEntity = repository.findCardByNumberAndPin(cardNumber,pin);
        if (cardEntity.isEmpty()) {
            throw new NullPointerException("Карта не найдена!");
        }
        else if (cardEntity.get().getExpireDate().isBefore(LocalDate.now())) {
            throw new IllegalStateException("Срок действия вашей карты истек!");
        }
        else return cardEntity.get().getId();
    }

}
