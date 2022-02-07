package com.github.voynova.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor

public class CardEntity {
    private UUID id;
    private int balance;
    private String pin;
    private String number;
    private LocalDate expireDate;
}
