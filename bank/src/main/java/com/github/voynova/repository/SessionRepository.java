package com.github.voynova.repository;

import com.github.voynova.entity.CardEntity;
import com.github.voynova.entity.SessionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface SessionRepository extends CrudRepository<SessionEntity, UUID> {
    SessionEntity getSessionEntityById(UUID id);
    SessionEntity getSessionEntityByCardAndAttemptTimestampIsAfter(CardEntity card, LocalDateTime timestamp);
}
