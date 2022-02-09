package com.github.voynova.repository;

import com.github.voynova.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CardRepository extends CrudRepository<CardEntity, UUID> {
    CardEntity findCardEntityById(UUID id);
    CardEntity findCardEntityByNumberAndPin(String number, String pin);
}
