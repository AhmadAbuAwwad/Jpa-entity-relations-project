package com.spring.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
    @Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid",
            nullable = false
    )
    private Long pid;
    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "holder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Balance> balances;
}
