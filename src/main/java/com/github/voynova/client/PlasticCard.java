package com.github.voynova.client;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class PlasticCard {
    private final String number;
    private final LocalDate expireDate;
}
