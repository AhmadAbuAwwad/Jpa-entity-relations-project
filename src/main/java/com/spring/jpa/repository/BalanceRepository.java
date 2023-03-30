package com.spring.jpa.repository;

import com.spring.jpa.DTO.balance.BalanceDTO;
import com.spring.jpa.DTO.balance.BalanceRelationDTO;
import com.spring.jpa.model.Balance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    //  Queries
    @Query("SELECT b FROM Balance b")
    public Collection<BalanceDTO> jpqlQueryFindAll();

    @Query(value = "SELECT * FROM balance b",
            nativeQuery = true)
    public Collection<BalanceDTO> nativeQueryFindAll();

    @Query("SELECT b FROM Balance b LEFT JOIN FETCH b.holder")
    public Collection<BalanceRelationDTO> fetchQuery();
}