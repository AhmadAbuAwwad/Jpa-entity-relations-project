package com.spring.jpa.DTO.finger_print;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.spring.jpa.DTO.balance.BalanceDTO;
import com.spring.jpa.DTO.person.PersonDTO;

import java.util.HashSet;
import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public interface FingerPrintRelationDTO extends FingerPrintDTO {
    PersonDTO getPerson();
}