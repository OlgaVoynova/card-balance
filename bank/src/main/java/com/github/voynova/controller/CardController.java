package com.github.voynova.controller;

import com.github.voynova.dto.request.CredentionalsDto;
import com.github.voynova.dto.response.AithorizationTokenDto;
import com.github.voynova.dto.response.CardBalanceDto;
import com.github.voynova.service.CardService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class CardController {

    private CardService service;

    @PostMapping("/card/authorization")
    public AithorizationTokenDto getAuthorization(@RequestBody CredentionalsDto credentionals) {
        try {
            /* позвращаем токен клиенту - ResponseEntity.ok */
            System.out.println(credentionals);
            return service.findCardId(credentionals.getCardNumber(),credentionals.getCardPin());
        } catch (NullPointerException | IllegalStateException e) {
            /* позвращаем ошибку клиенту - ResponseEntity.notOk */
            //TODO как возвращать ошибку?
            System.out.println(e.getMessage());
        }
        //TODO так делать некрасиво
        return null;
    }

    @GetMapping("/card/{cardId}/balance")
    public CardBalanceDto getCardBalance (@NonNull @PathVariable(name = "cardId") UUID cardId) {
        return  service.getCardBalanceById(cardId);
    }

}
