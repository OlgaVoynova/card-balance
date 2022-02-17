package com.github.voynova.sender;


import com.github.voynova.entity.Credentionals;
import com.github.voynova.entity.ResponseEnvelope;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class SenderRestTemplate implements Sender {
    @Override
    public int getCardBalance(UUID cardId) {
        /*RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Credentionals> request = new HttpEntity<>();*/
        return 0;
    }

    @Override
    public ResponseEnvelope getAuthorization(Credentionals credentionals) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Credentionals> request = new HttpEntity<>(credentionals);
        ResponseEntity<ResponseEnvelope> response = restTemplate.postForEntity("http://127.0.0.1:8080/card/authorization", request, ResponseEnvelope.class);
        return response.getBody();
    }
}
