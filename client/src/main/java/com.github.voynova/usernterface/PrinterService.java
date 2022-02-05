package com.github.voynova.usernterface;

import com.github.voynova.entity.Credentionals;

public interface PrinterService {
    void printAuthorizedMenu ();
    void printUnauthorizedMenu ();
    int enterMenuOption ();
    Credentionals enterCredentionals();
    void printCardBalance (int balance);
    void alreadyAuthorizedUserError();
    void unauthorizedUserError();
}
