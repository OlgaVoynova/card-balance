package com.github.voynova.utils;

import com.github.voynova.client.Human;
import com.github.voynova.client.PlasticCard;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PlasticCard card = new PlasticCard("123", LocalDate.now().plusDays(1000));
        Human me = new Human(card);
        me.toKnowCardBalance();
    }
}
