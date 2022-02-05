package com.github.voynova.client.usernterface;

import com.github.voynova.client.entity.Credentionals;

public interface PrinterService {
    void printAuthorizedMenu ();
    void printUnauthorizedMenu ();
    int enterMenuOption ();
    Credentionals enterCredentionals();
    void printCardBalance (int balance);
    void alreadyAuthorizedUserError();
    void unauthorizedUserError();
}
