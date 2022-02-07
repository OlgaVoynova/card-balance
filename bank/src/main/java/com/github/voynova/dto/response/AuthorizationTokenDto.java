package com.github.voynova.dto.response;

import lombok.Value;

import java.util.UUID;
@Value
public class AuthorizationTokenDto {
    private final UUID uuid;
}
