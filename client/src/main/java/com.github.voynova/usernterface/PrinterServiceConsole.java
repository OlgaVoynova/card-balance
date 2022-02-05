package com.github.voynova.client.usernterface;

import com.github.voynova.client.entity.Credentionals;

import java.util.Scanner;

public class PrinterServiceConsole implements PrinterService{

    private Scanner console;

    public PrinterServiceConsole () {
        this.console = new Scanner(System.in);
    }

    @Override
    public void printAuthorizedMenu () {
        System.out.println("1 - Получить баланс по карте");
        System.out.println("2 - Выход");
    }

    @Override
    public void printUnauthorizedMenu () {
        System.out.println("0 - Авторизация");
    }

    @Override
    public int enterMenuOption () {
        return console.nextInt();
    }

    @Override
    public Credentionals enterCredentionals() {
        String number;
        String pin;
        System.out.println("Введите номер карты: ");
        number = console.next();
        System.out.println("Введите пин-код: ");
        pin = console.next();
        return new Credentionals(number,pin);
    }

    @Override
    public void printCardBalance (int balance) {
        String header = balance>=0 ?
                "Баланс средств на карте: " :
                "Овердрафт на карте: ";
        System.out.println(header + balance);
    }

    @Override
    public void alreadyAuthorizedUserError() {
        System.out.println("Пользователь уже авторизован!");
    }

    @Override
    public void unauthorizedUserError() {
        System.out.println("Пользователь не авторизован!");
    }


}
