package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "simulator", schema = "crc_db", catalog = "")
public class SimulatorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "simulator_id", nullable = false)
    private long simulatorId;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Basic
    @Column(name = "abbr", nullable = false, length = 4)
    private String abbr;

    @Basic
    @Column(name = "release_date", nullable = true)
    private Date releaseDate;

    @Basic
    @Column(name = "producer", nullable = false, length = 255)
    private String producer;

    @Basic
    @Column(name = "logo_URL", nullable = true, length = 255)
    private String logoUrl;

    @Basic
    @Column(name = "active", nullable = false)
    private byte active;

    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "simulator")
    private Collection<ChampionshipEntity> championships;

    @OneToMany(mappedBy = "simulator")
    private Collection<LiveryEntity> liveries;

    @OneToMany(mappedBy = "simulator")
    private Collection<SimulatorCarEntity> simulatorCars;

    @OneToMany(mappedBy = "simulator")
    private Collection<SimulatorCarCategoryEntity> simulatorCarCategories;

    @OneToMany(mappedBy = "simulator")
    private Collection<SimulatorCircuitLayoutEntity> simulatorCircuitLayouts;

    @OneToMany(mappedBy = "simulator")
    private Collection<SimulatorCountryEntity> simulatorCountries;

    @OneToMany(mappedBy = "simulator")
    private Collection<SimulatorCupCategoryEntity> simulatorCupCategories;

    @OneToMany(mappedBy = "simulator")
    private Collection<SimulatorLicenseEntity> simulatorLicenses;
}
