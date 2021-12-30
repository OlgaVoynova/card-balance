package com.github.voynova.bank;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
//Методы этого класса должны быть доступны только BankingService
public class Card {
    private final int balance;
    private final String pin;
    private final String number;
    private final LocalDate expireDate;
}
