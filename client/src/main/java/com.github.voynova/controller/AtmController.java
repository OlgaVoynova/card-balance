package com.github.voynova.client.controller;


import com.github.voynova.client.service.AtmService;
import com.github.voynova.client.usernterface.PrinterService;
import com.github.voynova.client.usernterface.PrinterServiceConsole;

import java.util.UUID;

/* Поднимается каждый раз для нового пользователя */
public class AtmController {
    private UUID cardId;
    private AtmService atmService;
    private PrinterService printer;

    public AtmController() {
        this.printer = new PrinterServiceConsole();
        this.atmService = new AtmService();
    }

    private void getCardBalance () {
        printer.printCardBalance(atmService.getCardBalance(cardId));
    }

    private void authorization () {
        if (this.cardId != null ) {
            printer.alreadyAuthorizedUserError();
        } else {
            UUID cardIdFromBank = atmService.getAuthorization(printer.enterCredentionals());
            if (cardIdFromBank == null) {
                /* хорошо бы именно здесь печатать, почему: не совпали номер-пин или карта истела */
                printer.unauthorizedUserError();
            } else
                this.cardId = cardIdFromBank;
        }
    }

    private void signOff () {
        this.cardId = null;
    }

    public void getAtmOperations () {
        int i = 0;
        /*TODO В зависимости от опции выбираем метод */
        while (i != 9) {
            if (cardId == null)
                printer.printUnauthorizedMenu();
            else
                printer.printAuthorizedMenu();
            i = printer.enterMenuOption();
            switch (i) {
                case 0: {
                    authorization();
                    break;
                }
                case 1: {
                    getCardBalance();
                    break;
                }
                case 2: {
                    signOff();
                    break;
                }
                default: {
                    break;
                }
            }

        }
    }
}
