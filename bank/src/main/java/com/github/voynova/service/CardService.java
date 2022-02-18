package com.github.voynova.service;

import com.github.voynova.dto.response.CardBalanceDto;
import com.github.voynova.entity.CardEntity;
import com.github.voynova.entity.SessionEntity;
import com.github.voynova.entity.additional.*;
import com.github.voynova.repository.CardRepository;
import com.github.voynova.repository.SessionRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CardService {

    private CardRepository cardRepository;
    private SessionRepository sessionRepository;

    private final static int SESSION_DURATION_MINUTES = 2;

    /**
     * Возвращает баланс карты по идентификатору сессии сессия
     * @param sessionId идентификатор сессии
     * @return баланс карты
     * @throws IllegalAccessException если нет действующей сессии
     */
    public CardBalanceDto getCardBalance (@NonNull UUID sessionId) throws IllegalAccessException {
        SessionEntity session = sessionRepository.getSessionEntityById(sessionId);
        if (session == null || session.getCard() == null || session.getAttemptTimestamp().isBefore(LocalDateTime.now().minusMinutes(SESSION_DURATION_MINUTES))) {
            throw new IllegalAccessException("AUTHORIZATION NEEDED");
        } else {
            return new CardBalanceDto(session.getCard().getBalance());
        }
    }

    /**
     * Открывает сессию на 2 минуты или возвращает действующую
     * @param cardNumber номер карты
     * @param pin пин код карты
     * @return идентификатор сессии: новой или действующей
     * @throws IllegalArgumentException если не найдена карта по заданным credentials
     * @throws IllegalStateException если срок действия карты истек
     */
    public UUID getSession (@NonNull String cardNumber, @NonNull String pin) throws IllegalStateException, IllegalArgumentException {
        CardEntity cardEntity = cardRepository.findCardEntityByNumberAndPin(cardNumber,pin);
        if (cardEntity == null) {
            sessionRepository.save(new SessionEntity(null,false, AuthorizationFailCode.CARD_NOT_FOUND));
            throw new IllegalArgumentException("CARD NOT FOUND");
        }
        else if (cardEntity.getExpireDate().isBefore(LocalDate.now())) {
            sessionRepository.save(new SessionEntity(cardEntity,false, AuthorizationFailCode.CARD_EXPIRED));
            throw new IllegalStateException("CARD IS EXPIRED");
        }
        else {
            SessionEntity session = sessionRepository.getSessionEntityByCardAndAttemptTimestampIsAfter(cardEntity,LocalDateTime.now().minusMinutes(SESSION_DURATION_MINUTES));
            if (session == null) {
                session = new SessionEntity(cardEntity,true, null);
                sessionRepository.save(session);
            }
            return session.getId();
        }
    }

}
