package com.github.voynova.bank;

import lombok.NonNull;

import java.util.List;

public class BankingService {
    List<Card> cards;
    List<User> users;

    public BankingService () {
        Card c = new Card(100,"456","123");
        cards.add(c);
        users.add(new User(c));
    }
    public int getCardBalance (Card card) {
        return card.getBalance();
    }

    public User findUser (String cardNumber, @NonNull String pin) {
        //TODO
        Card card = cards.stream()
                .filter(c -> cardNumber.equals(c.getNumber()) && pin.equals(c.getPin()))
                .findFirst()
                .orElse(null);
        if (card != null) {
            return users.stream()
                    .filter(x -> x.getCard(cardNumber) != null)
                    .findAny()
                    .orElse(null);
        }
        else  return null;
    }

}
