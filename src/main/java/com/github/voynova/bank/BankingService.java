package com.github.voynova.bank;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankingService {
    List<Card> cards;

    public BankingService () {
        cards = new ArrayList<>();
        Card c = new Card(100,"456","123",LocalDate.now().plusDays(1000));
        cards.add(c);
    }
    public int getCardBalance (Card card) {
        return card.getBalance();
    }

    public Card findCard (String cardNumber, @NonNull String pin) {
        //TODO
        Card card = cards.stream()
                .filter(c -> cardNumber.equals(c.getNumber()) && pin.equals(c.getPin()))
                .findFirst()
                .orElse(null);
        if (card.getExpireDate().isBefore(LocalDate.now())) {
            System.out.println("Срок действия вашей карты истек. Обратитесь в банк для замены карты!");
            return null;
        }
        if (card != null ) {
            return card;
        }
        else return null;
    }

}
