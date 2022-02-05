package com.github.voynova;

import com.github.voynova.client.controller.AtmController;

public class Main {
    public static void main(String[] args) {
        AtmController atm   = new AtmController();
        atm.getAtmOperations();
    }
}
