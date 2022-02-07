package com.github.voynova.service;

import com.github.voynova.dto.response.AuthorizationTokenDto;
import com.github.voynova.dto.response.CardBalanceDto;
import com.github.voynova.entity.CardEntity;
import com.github.voynova.exception.AuthorizationFailedException;
import com.github.voynova.repository.CardRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

    private CardRepository repository;

    public CardService() {
        this.repository = new CardRepository();
    }

    public CardBalanceDto getCardBalanceById (@NonNull UUID cardId) {
        return new CardBalanceDto(repository.findCardById(cardId).get().getBalance());
    }

    public AuthorizationTokenDto findCardId (@NonNull String cardNumber, @NonNull String pin) {
        Optional<CardEntity> cardEntity = repository.findCardByNumberAndPin(cardNumber,pin);
        if (cardEntity.isEmpty()) {
            throw new AuthorizationFailedException("Карта не найдена!");
        }
        else if (cardEntity.get().getExpireDate().isBefore(LocalDate.now())) {
            throw new AuthorizationFailedException("Срок действия вашей карты истек!");
        }
        else return new AuthorizationTokenDto(cardEntity.get().getId());
    }

}
