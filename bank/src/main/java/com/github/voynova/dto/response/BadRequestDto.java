package com.github.voynova.dto.response;

import lombok.Value;

@Value
public class BadRequestDto {
    private final String errorCode;
    private final String errorDesc;
}
