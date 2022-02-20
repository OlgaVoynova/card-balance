package com.github.voynova.entity;

import lombok.Value;

import java.io.Serializable;

@Value
public class BalanceResponse implements Serializable {
    private final int balance;
}
