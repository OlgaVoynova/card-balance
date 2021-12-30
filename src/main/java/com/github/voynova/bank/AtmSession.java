package com.github.voynova.bank;

import com.github.voynova.client.PlasticCard;

import java.time.LocalDate;

public class AtmSession {

    private static BankingService service;

    User user;
    PlasticCard plasticCard;

    private static final Integer PIN_ENTER_RETRY = 3;

    private AtmSession(PlasticCard plasticCard, User user) {
        this.user = user;
        this.plasticCard = plasticCard;
    }

    public static AtmSession startAtmService (PlasticCard plasticCard) {
        service = new BankingService(); /* Пробуем соединиться с банком */
        User authUser = authorization(plasticCard);
        if (authUser != null) {
            return new AtmSession(plasticCard,authUser);
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
        if (this.plasticCard.getExpireDate().isAfter(LocalDate.now())) {
            System.out.println(service.getCardBalance(this.user.getCard(plasticCard.getNumber())));
        } else {
            System.out.println("Обратитесь в банк для замены карты: срок действия текущей карты истек!");
        }
    }

    private static User authorization(PlasticCard card) {
        User user;
        for (int i=0; i<PIN_ENTER_RETRY; i++) {
            System.out.println("Введите пин-код: ");
            String pin = "456";
            user = service.findUser(card.getNumber(),pin);
            if(user != null) {
                return user;
            }
        }
        return null;
    }

    private void removeCard() {
        System.out.println("До свидания!");
        this.plasticCard = null;
    }

}
