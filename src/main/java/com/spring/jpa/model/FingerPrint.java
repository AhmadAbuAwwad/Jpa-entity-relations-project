package com.spring.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "prints")
public class FingerPrint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fid",
            updatable = false,
            nullable = false
    )
    private Long fid;
    @Column(name = "data")
    private String data;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person person;
}
