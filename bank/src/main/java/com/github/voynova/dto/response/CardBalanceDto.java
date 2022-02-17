package com.github.voynova.dto.response;

import lombok.Value;

import java.io.Serializable;

@Value
public class CardBalanceDto implements Serializable {
    private final int balance;
}
