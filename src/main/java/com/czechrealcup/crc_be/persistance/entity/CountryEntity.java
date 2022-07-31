package com.czechrealcup.crc_be.persistance.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country", schema = "crc_db")
public class CountryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id", nullable = false)
    private long countryId;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "abbr", nullable = false, length = 3)
    private String abbr;

    @Basic
    @Column(name = "flag_URL", nullable = false)
    private String flagUrl;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "country")
    private Collection<CircuitEntity> circuits;

    @ManyToOne
    @JoinColumn(name = "continent_id", referencedColumnName = "continent_id", nullable = false)
    private ContinentEntity continent;

    @OneToMany(mappedBy = "country")
    private Collection<ManufacturerEntity> manufacturers;

    @OneToMany(mappedBy = "country")
    private Collection<SimulatorCountryEntity> simulatorCountries;

    @OneToMany(mappedBy = "country")
    private Collection<UserEntity> users;
}
