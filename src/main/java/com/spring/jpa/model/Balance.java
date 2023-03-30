package com.spring.jpa.model;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid",
            updatable = false,
            nullable = false
    )
    private Long bid;
    @Column(name = "balance")
    private int balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private Person holder;

}
