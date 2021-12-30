package com.github.voynova.utils;

import com.github.voynova.bank.AtmSession;
import com.github.voynova.client.PlasticCard;

public class Main {
    public static void main(String[] args) {
        PlasticCard card = new PlasticCard("123");
        AtmSession atmSession = AtmSession.startAtmService(card);
        atmSession.atmMenu();
    }
}
