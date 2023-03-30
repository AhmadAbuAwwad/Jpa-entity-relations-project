package com.spring.jpa.controller;

import com.spring.jpa.DTO.balance.BalanceDTO;
import com.spring.jpa.DTO.balance.BalanceRelationDTO;
import com.spring.jpa.model.Balance;
import com.spring.jpa.repository.BalanceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Controller for Drugs
 */

@RestController
@RequestMapping("/api")
public class BalanceController
{
    @Autowired
    private ModelMapper modelMapper;

    private BalanceDTO convertToDto(Balance balance) {
        BalanceDTO balanceDTO = modelMapper.map(balance, BalanceDTO.class);
        return balanceDTO;
    }

    @Autowired
    private BalanceRepository balanceRepository;

    @GetMapping("/findAllList")
    public ResponseEntity<Collection<BalanceDTO>> find(){
        Collection<BalanceDTO> balances = balanceRepository.jpqlQueryFindAll();
        return new ResponseEntity<>(balances, HttpStatus.OK);
    }

    @GetMapping("/findList")
    public ResponseEntity<Collection<BalanceDTO>> findList(){
        Collection<BalanceDTO> balances = balanceRepository.nativeQueryFindAll();
        return new ResponseEntity<>(balances, HttpStatus.OK);
    }

    @GetMapping("/fetchFind")
    public ResponseEntity<Collection<BalanceRelationDTO>> fetchQuery(){
        Collection<BalanceRelationDTO> balances = balanceRepository.fetchQuery();
        return new ResponseEntity<>(balances, HttpStatus.OK);
    }
}