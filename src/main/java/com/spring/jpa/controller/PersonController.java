package com.spring.jpa.controller;

import com.spring.jpa.DTO.balance.BalanceDTO;
import com.spring.jpa.DTO.person.PersonDTO;
import com.spring.jpa.DTO.person.PersonBalanceRelationDTO;
import com.spring.jpa.DTO.person.PersonFingerRelationDTO;
import com.spring.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Controller for Drugs
 */

@RestController
@RequestMapping("/api/person")
public class PersonController
{
    @Autowired
    private PersonRepository personRepository;
    @GetMapping("/findAllJPQL")
    public ResponseEntity<Collection<PersonDTO>> findAll(){
        Collection<PersonDTO> personDTOs = personRepository.jpqlQueryFindAll();
        return new ResponseEntity<>(personDTOs, HttpStatus.OK);
    }

    @GetMapping("/findAllNative")
    public ResponseEntity<Collection<PersonDTO>> findNative(){
        Collection<PersonDTO> personDTOs = personRepository.nativeQueryFindAll();
        return new ResponseEntity<>(personDTOs, HttpStatus.OK);
    }

    @GetMapping("/findAllWithBalances")
    public ResponseEntity<Collection<PersonBalanceRelationDTO>> findAllWithBalances(){
        Collection<PersonBalanceRelationDTO> personDTOs = personRepository.findWithBalances();
        return new ResponseEntity<>(personDTOs, HttpStatus.OK);
    }
}