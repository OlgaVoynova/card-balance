package com.github.voynova.entity;

import com.github.voynova.entity.additional.AuthorizationFailCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "session")
public class SessionEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name="card_guid")
    private CardEntity card;

    private LocalDateTime attemptTimestamp = LocalDateTime.now();

    private boolean successAttempt;

    @Enumerated(EnumType.STRING)
    private AuthorizationFailCode failCode;

    public SessionEntity (CardEntity card, boolean success, AuthorizationFailCode failCode) {
        this.card = card;
        this.successAttempt = success;
        this.failCode = failCode;
    }

}
