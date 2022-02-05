package com.github.voynova.client.service;

public interface PrinterService {
    void printAuthorizedMenu ();
    void printUnauthorizedMenu ();
    int enterMenuOption ();
    String enterCardNumber ();
    String enterCardPin ();
    void printCardBalance (int balance);
    void alreadyAuthorizedUserError();
    void serviceUnavailable(String message);
}
