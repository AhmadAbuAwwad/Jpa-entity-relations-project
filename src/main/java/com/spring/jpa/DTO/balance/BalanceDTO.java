package com.spring.jpa.DTO.balance;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public interface BalanceDTO {
    Long getBid();
    int getBalance();
}