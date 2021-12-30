package com.github.voynova.bank;

import com.github.voynova.client.PlasticCard;

import java.time.LocalDate;

public class AtmSession {

    private static BankingService service;

    Card digitalCard;
    PlasticCard plasticCard;

    private static final Integer PIN_ENTER_RETRY = 3;

    private AtmSession(PlasticCard plasticCard, Card digitalCard) {
        this.digitalCard = digitalCard;
        this.plasticCard = plasticCard;
    }

    public static AtmSession startAtmService (PlasticCard plasticCard) {
        service = new BankingService(); /* Пробуем соединиться с банком */
        Card card = authorization(plasticCard);
        if (card != null) {
            return new AtmSession(plasticCard,card);
        }
        else {
            System.out.println("До свидания!");
            throw new IllegalCallerException("Пользователь не прошел авторизацию!");
        }
    }

    public void atmMenu () {
        System.out.println("Получить баланс - нажмите 1");
        System.out.println("Выйти - 2");
        String command = "1";
        boolean toContinue = true;
        while(toContinue) {

            switch (command) {
                case ("1"): {
                    getCardBalance();
                    break;
                }
                case ("2"): {
                    toContinue = false;
                    removeCard();
                    break;
                }
                default: {
                    break;
                }
            }
            System.out.println("Получить баланс - нажмите 1");
            System.out.println("Выйти - 2");
            command = "2";
        }
    }

    private void getCardBalance() {
        System.out.println("Баланс карты: " + service.getCardBalance(digitalCard));
    }

    private static Card authorization(PlasticCard card) {
        Card foundCard;
        for (int i=0; i<PIN_ENTER_RETRY; i++) {
            System.out.println("Введите пин-код: ");
            String pin = "456";
            foundCard = service.findCard(card.getNumber(),pin);
            if(foundCard != null) {
                return foundCard;
            }
        }
        return null;
    }

    private void removeCard() {
        System.out.println("До свидания!");
        this.plasticCard = null;
        this.digitalCard = null;
    }

}
