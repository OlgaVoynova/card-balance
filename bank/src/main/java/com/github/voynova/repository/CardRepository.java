package com.github.voynova.repository;

import com.github.voynova.entity.CardEntity;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public class CardRepository {

    private List<CardEntity> cardEntities;

    public CardRepository() {
        cardEntities = new ArrayList<>();
        CardEntity c1 = new CardEntity(UUID.randomUUID(),123,"123","123", LocalDate.now().plusDays(123));
        CardEntity c2 = new CardEntity(UUID.randomUUID(),456,"456","456", LocalDate.now().minusDays(456));
        CardEntity c3 = new CardEntity(UUID.randomUUID(),-789,"789","789", LocalDate.now().plusDays(789));
        cardEntities = List.of(c1,c2,c3);
    }

    public Stream<CardEntity> findAll() {
        return cardEntities.stream();
    }

    public Optional<CardEntity> findCardByNumberAndPin (@NonNull String cardNumber, @NonNull String pin) {
        return cardEntities.stream()
                .filter(x -> cardNumber.equals(x.getNumber()))
                .filter(x -> pin.equals(x.getPin()))
                .findFirst();
    }

    public Optional<CardEntity> findCardById (@NonNull UUID id) {
        return cardEntities.stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst();
    }

    public void addCard(CardEntity card) {
        cardEntities.add(card);
    }
}
