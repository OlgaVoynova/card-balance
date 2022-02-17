package com.github.voynova.controller;

/*
import com.github.voynova.service.AtmService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;
*/
public class AtmControllerOld {/*
    //private UUID cardId;
    private AtmService atmService;
    //private PrinterService printer;
/*
    public AtmController() {
        //this.printer = new PrinterServiceConsole();
        this.atmService = new AtmService();
    }*/
/*
    @PostMapping("/ATM/card/{guid}/balance")
    private void getCardBalance (@PathVariable("guid") UUID cardGuid) {

        printer.printCardBalance(atmService.getCardBalance(cardId));
    }

    private void authorization () {
        if (this.cardId != null ) {
            printer.alreadyAuthorizedUserError();
        } else {
            UUID cardIdFromBank = atmService.getAuthorization(printer.enterCredentionals());
            if (cardIdFromBank == null) {*/
                /* хорошо бы именно здесь печатать, почему: не совпали номер-пин или карта истекла */
               /* printer.unauthorizedUserError();
            } else
                this.cardId = cardIdFromBank;
        }
    }

    private void signOff () {
        this.cardId = null;
    }

    public void getAtmOperations () {
        int i = 0;*/
        /* В зависимости от опции выбираем метод */
        /*while (i != 9) {
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
    }*/
}
