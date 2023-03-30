package com.spring.jpa.repository;

import com.spring.jpa.DTO.person.PersonDTO;
import com.spring.jpa.DTO.person.PersonBalanceRelationDTO;
import com.spring.jpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    //  Queries

    @Query(value = "SELECT * FROM person p",
            nativeQuery = true)
    public Collection<PersonDTO> nativeQueryFindAll();

    @Query("SELECT p FROM Person p")
    public Collection<PersonDTO> jpqlQueryFindAll();

    @Query("SELECT p FROM Person p  LEFT JOIN FETCH p.balances")
    public Collection<PersonBalanceRelationDTO> findWithBalances();
}