package com.github.voynova.client.service;

import java.util.Scanner;

public class PrinterServiceConsole implements PrinterService{

    private Scanner console;

    public PrinterServiceConsole () {
        this.console = new Scanner(System.in);
    }
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
    public String enterCardNumber () {
        System.out.println("Введите номер карты: ");
        return console.next();
    }

    public String enterCardPin () {
        System.out.println("Введите пин-код: ");
        return console.next();
    }

    public void printCardBalance (int balance) {
        String header = balance>=0 ?
                "Баланс средств на карте: " :
                "Овердрафт на карте: ";
        System.out.println(header + balance);
    }

    public void alreadyAuthorizedUserError() {
        System.out.println("Пользователь уже авторизован!");
    }

    public void serviceUnavailable(String message) {
        System.out.println("В данный момент сервис недоступен: " + message);
    }
}
