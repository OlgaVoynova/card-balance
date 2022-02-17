package com.github.voynova.controller;


import com.github.voynova.entity.Credentionals;
import com.github.voynova.service.AtmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/* Поднимается каждый раз для нового пользователя */
@RestController
@AllArgsConstructor
//TODO в этих методах должны вызываться методы сервиса, который передает данные через Rest Template В bank
public class AtmController {
    //private UUID cardId;
    private AtmService atmService;
    //private PrinterService printer;
/*
    public AtmController() {
        //this.printer = new PrinterServiceConsole();
        this.atmService = new AtmService();
    }*/

    @GetMapping("/ATM/card/{guid}/balance")
    private void getCardBalance (@PathVariable("guid") UUID cardGuid) {

        //printer.printCardBalance(atmService.getCardBalance(cardGuid));
        System.out.println("Запрашиваю баланс по карте " + cardGuid);
    }

    @PostMapping("/ATM/card/authorization")
    private UUID authorization (Credentionals credentionals) {
        /*
        if (this.cardId != null ) {
            printer.alreadyAuthorizedUserError();
        } else {
            UUID cardIdFromBank = atmService.getAuthorization(printer.enterCredentionals());
            if (cardIdFromBank == null) {
                printer.unauthorizedUserError();
            } else
                this.cardId = cardIdFromBank;
        }*/
        System.out.println("Credentionals: " + credentionals);
        return UUID.randomUUID();
    }
/*
    public void getAtmOperations () {
        int i = 0;
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
 */
}
