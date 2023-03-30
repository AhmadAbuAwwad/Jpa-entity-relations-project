package com.spring.jpa.repository;

import com.spring.jpa.DTO.balance.BalanceDTO;
import com.spring.jpa.DTO.balance.BalanceRelationDTO;
import com.spring.jpa.DTO.finger_print.FingerPrintDTO;
import com.spring.jpa.DTO.finger_print.FingerPrintRelationDTO;
import com.spring.jpa.DTO.person.PersonFingerRelationDTO;
import com.spring.jpa.model.Balance;
import com.spring.jpa.model.FingerPrint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FingerPrintRepository extends JpaRepository<FingerPrint, Long> {

    //  Queries
    @Query("SELECT f FROM FingerPrint f")
    public Collection<FingerPrintDTO> jpqlQueryFindAll();

    @Query(value = "SELECT * FROM prints f",
            nativeQuery = true)
    public Collection<FingerPrintDTO> nativeQueryFindAll();


    @Query("SELECT f FROM FingerPrint f LEFT JOIN FETCH f.person")
    public Collection<FingerPrintRelationDTO> fetchQuery();
}