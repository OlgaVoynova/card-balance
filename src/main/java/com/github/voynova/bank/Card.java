package com.github.voynova.bank;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Card {
    private final int balance;
    private final String pin;
    private final String number;
}
