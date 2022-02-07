package com.github.voynova.controller;

import com.github.voynova.dto.request.CredentionalsDto;
import com.github.voynova.dto.response.AuthorizationTokenDto;
import com.github.voynova.dto.response.CardBalanceDto;
import com.github.voynova.exception.AuthorizationFailedException;
import com.github.voynova.service.CardService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class CardController {

    private CardService service;

    @PostMapping("/card/authorization")
    public ResponseEntity<AuthorizationTokenDto> getAuthorization(@RequestBody CredentionalsDto credentionals) {
        try {
            //System.out.println(credentionals);
            return ResponseEntity.ok(service.findCardId(credentionals.getCardNumber(),credentionals.getCardPin()));
        } catch (AuthorizationFailedException e) {
            //TODO как возвращать ошибку с нормальным описанием?
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
        //return ResponseEntity.ok(service.findCardId(credentionals.getCardNumber(),credentionals.getCardPin()));
    }

    @GetMapping("/card/{cardId}/balance")
    public ResponseEntity<CardBalanceDto> getCardBalance (@NonNull @PathVariable(name = "cardId") UUID cardId) {
        return ResponseEntity.ok(service.getCardBalanceById(cardId));
    }

}
