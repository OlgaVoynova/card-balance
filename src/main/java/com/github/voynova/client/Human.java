package com.github.voynova.client;

import com.github.voynova.bank.AtmSession;

public class Human {

    private PlasticCard creditCard;

    public Human (PlasticCard card) {
        this.creditCard = card;
    }

    public void toKnowCardBalance() {
        AtmSession atmSession = AtmSession.startAtmService(creditCard);
    }

}
