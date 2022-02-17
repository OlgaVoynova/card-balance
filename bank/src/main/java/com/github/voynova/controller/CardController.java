package com.github.voynova.controller;

import com.github.voynova.dto.request.CredentialsDto;
import com.github.voynova.dto.response.ResponseEnvelope;
import com.github.voynova.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class CardController {

    private CardService service;

    @PostMapping("/card/authorization")
    public ResponseEnvelope getAuthorization(@RequestBody CredentialsDto credentials) {
        try {
            return new ResponseEnvelope(HttpStatus.OK.toString(),null,service.getSession(credentials.getCardNumber(),credentials.getCardPin()));
        } catch (IllegalArgumentException | IllegalStateException e) {
            return new ResponseEnvelope(HttpStatus.BAD_REQUEST.toString(),e.getMessage(),null);
        }
    }

    @GetMapping("/card/{sessionId}/balance")
    public ResponseEnvelope getCardBalance (@PathVariable(name = "sessionId") UUID sessionId) {
        try {
            return new ResponseEnvelope(HttpStatus.OK.toString(),null,service.getCardBalance(sessionId));
        } catch (IllegalAccessException e) {
            return new ResponseEnvelope(HttpStatus.BAD_REQUEST.toString(),e.getMessage(),null);
        }
    }

}
