package com.github.voynova.exception;

import io.swagger.codegen.v3.service.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AuthorizationFailedException extends BadRequestException {

    public AuthorizationFailedException(String msg) {
        super(msg);
    }
}
