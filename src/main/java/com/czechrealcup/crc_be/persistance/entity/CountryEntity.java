package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "country", schema = "crc_db", catalog = "")
public class CountryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id", nullable = false)
    private long countryId;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Basic
    @Column(name = "abbr", nullable = false, length = 3)
    private String abbr;

    @Basic
    @Column(name = "flag_URL", nullable = false, length = 255)
    private String flagUrl;

    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "country")
    private Collection<CircuitEntity> circuits;

    @ManyToOne
    @JoinColumn(name = "continent_id", referencedColumnName = "continent_id", nullable = false)
    private ContinentEntity continent;

    @OneToMany(mappedBy = "countryByCountryId")
    private Collection<ManufacturerEntity> manufacturers;

    @OneToMany(mappedBy = "countryByCountryId")
    private Collection<SimulatorCountryEntity> simulatorCountries;

    @OneToMany(mappedBy = "countryByCountryId")
    private Collection<UserEntity> users;

}
