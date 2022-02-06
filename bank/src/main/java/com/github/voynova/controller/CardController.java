package com.github.voynova.controller;

import com.github.voynova.dto.AithorizationTokenDto;
import com.github.voynova.dto.CardBalanceDto;
import com.github.voynova.service.CardService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class CardController {

    private CardService service;

    @PostMapping("/card/authorize/{cardNumber}/{cardPin}")
    public AithorizationTokenDto getAuthorization(@NonNull @PathVariable("cardNumber") String cardNumber,
                                                  @NonNull @PathVariable("cardPin") String cardPin) {
        try {
            /* позвращаем токен клиенту - ResponseEntity.ok */
            return service.findCardId(cardNumber,cardPin);
        } catch (NullPointerException | IllegalStateException e) {
            /* позвращаем ошибку клиенту - ResponseEntity.notOk */
            //TODO как возвращать ошибку?
            System.out.println(e.getMessage());
        }
        //TODO так делать некрасиво
        return null;
    }

    @PostMapping("/card/{cardId}/balance")
    public CardBalanceDto getCardBalance (@NonNull @PathVariable UUID cardId) {
        return  service.getCardBalanceById(cardId);
    }

}
