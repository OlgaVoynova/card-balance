package com.github.voynova.bank;

import lombok.NonNull;

import java.util.List;

public class User {
    List<Card> cards;

    public User (Card card) {
        cards.add(card);
    }

    public Card getCard (String number) {
        Card c = cards.stream().filter(x -> number.equals(x.getNumber())).findFirst().orElse(null);
        return c;
    }
}
