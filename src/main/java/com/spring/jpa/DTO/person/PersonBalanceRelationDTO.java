package com.spring.jpa.DTO.person;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.spring.jpa.DTO.balance.BalanceDTO;

import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public interface PersonBalanceRelationDTO extends PersonDTO {
    Set<BalanceDTO> getBalances();
}