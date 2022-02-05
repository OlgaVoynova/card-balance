package com.github.voynova.client.controller;


import com.github.voynova.bank.controller.CardController;
import com.github.voynova.client.service.PrinterService;
import com.github.voynova.client.service.PrinterServiceConsole;

import java.io.IOException;
import java.util.UUID;

/* Поднимается каждый раз для нового пользователя */
public class AtmController {
    private UUID cardId;
    private CardController cardController;
    private PrinterService printer;

    public AtmController() {
        this.cardController = new CardController();
        this.printer = new PrinterServiceConsole();
    }

    public void getCardBalance () {
        printer.printCardBalance(cardController.getCardBalance(cardId));
    }

    public void authorization () {
        if (this.cardId != null ) {
            printer.alreadyAuthorizedUserError();
        }else {
            this.cardId = cardController.getAuthorization(printer.enterCardNumber(), printer.enterCardPin());
        }
    }

    public void signOff () {
        this.cardId = null;
    }

    public void getAtmOperations () {
        int i = 0;
        if (cardId == null)
            printer.printUnauthorizedMenu();
        else
            printer.printAuthorizedMenu();
        i = printer.enterMenuOption();

        /*TODO В зависимости от опции выбираем метод - ПАТТЕРН СТРАТЕГИЯ */
        while (i != 2) {
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
                    getAtmOperations();
                    break;
                }
            }
            if (cardId == null)
                printer.printUnauthorizedMenu();
            else
                printer.printAuthorizedMenu();
            i = printer.enterMenuOption();
        }
    }
}
