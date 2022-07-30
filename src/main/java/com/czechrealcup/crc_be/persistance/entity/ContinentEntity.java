package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "continent", schema = "crc_db", catalog = "")
public class ContinentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "continent_id", nullable = false)
    private long continentId;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @OneToMany(mappedBy = "continent")
    private List<CountryEntity> countries;
}
