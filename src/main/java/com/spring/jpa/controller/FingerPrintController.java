package com.spring.jpa.controller;

import com.spring.jpa.DTO.finger_print.FingerPrintDTO;
import com.spring.jpa.DTO.finger_print.FingerPrintRelationDTO;
import com.spring.jpa.DTO.person.PersonBalanceRelationDTO;
import com.spring.jpa.DTO.person.PersonDTO;
import com.spring.jpa.DTO.person.PersonFingerRelationDTO;
import com.spring.jpa.repository.FingerPrintRepository;
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
@RequestMapping("/api/print")
public class FingerPrintController
{
    @Autowired
    private FingerPrintRepository fingerPrintRepository;
    @GetMapping("/findAllJPQL")
    public ResponseEntity<Collection<FingerPrintDTO>> findAll(){
        Collection<FingerPrintDTO> fingerPrintDTOs = fingerPrintRepository.jpqlQueryFindAll();
        return new ResponseEntity<>(fingerPrintDTOs, HttpStatus.OK);
    }

    @GetMapping("/findAllNative")
    public ResponseEntity<Collection<FingerPrintDTO>> findNative(){
        Collection<FingerPrintDTO> fingerPrintDTOs = fingerPrintRepository.nativeQueryFindAll();
        return new ResponseEntity<>(fingerPrintDTOs, HttpStatus.OK);
    }

    @GetMapping("/fetchFind")
    public ResponseEntity<Collection<FingerPrintRelationDTO>> fetchFind(){
        Collection<FingerPrintRelationDTO> fingerPrintRelationDTOs = fingerPrintRepository.fetchQuery();
        return new ResponseEntity<>(fingerPrintRelationDTOs, HttpStatus.OK);
    }
}