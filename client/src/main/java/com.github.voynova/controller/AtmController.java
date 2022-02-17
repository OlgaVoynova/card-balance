package com.github.voynova.controller;


import com.github.voynova.entity.Credentionals;
import com.github.voynova.entity.ResponseEnvelope;
import com.github.voynova.service.AtmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@AllArgsConstructor
//TODO в этих методах должны вызываться методы сервиса, который передает данные через Rest Template В bank
public class AtmController {

    private AtmService atmService;

    @GetMapping("/ATM/card/{guid}/balance")
    private ResponseEnvelope getCardBalance (@PathVariable("guid") UUID cardGuid) {
        return atmService.getCardBalance(cardGuid);
    }

    @PostMapping("/ATM/card/authorization")
    private ResponseEnvelope authorization (@RequestBody Credentionals credentionals) {
        return atmService.getAuthorization(credentionals);
    }

}
