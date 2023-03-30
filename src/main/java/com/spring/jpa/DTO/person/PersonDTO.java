package com.spring.jpa.DTO.person;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public interface PersonDTO {
    Long getPid();
    String getName();
}