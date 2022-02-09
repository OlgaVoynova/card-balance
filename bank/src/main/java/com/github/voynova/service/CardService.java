package com.github.voynova.service;

import com.github.voynova.dto.response.AuthorizationTokenDto;
import com.github.voynova.dto.response.CardBalanceDto;
import com.github.voynova.entity.CardEntity;
import com.github.voynova.exception.AuthorizationFailedException;
import com.github.voynova.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CardService {

    private CardRepository repository;

    public CardBalanceDto getCardBalanceById (@NonNull UUID cardId) {
        CardEntity card = repository.findCardEntityById(cardId);
        if (card == null) {
            throw new AuthorizationFailedException("Карта не найдена!");
        } else
            return new CardBalanceDto(card.getBalance());
    }

    public AuthorizationTokenDto findCardId (@NonNull String cardNumber, @NonNull String pin) {
        CardEntity cardEntity = repository.findCardEntityByNumberAndPin(cardNumber,pin);
        if (cardEntity == null) {
            throw new AuthorizationFailedException("Карта не найдена!");
        }
        else if (cardEntity.getExpireDate().isBefore(LocalDate.now())) {
            throw new AuthorizationFailedException("Срок действия вашей карты истек!");
        }
        else return new AuthorizationTokenDto(cardEntity.getId());
    }

}
