package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
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
    private Collection<ChampionshipEntity> championshipsBySimulatorId;
    @OneToMany(mappedBy = "simulatorBySimulatorId")
    private Collection<LiveryEntity> liveriesBySimulatorId;
    @OneToMany(mappedBy = "simulatorBySimulatorId")
    private Collection<SimulatorCarEntity> simulatorCarsBySimulatorId;
    @OneToMany(mappedBy = "simulatorBySimulatorId")
    private Collection<SimulatorCarCategoryEntity> simulatorCarCategoriesBySimulatorId;
    @OneToMany(mappedBy = "simulatorBySimulatorId")
    private Collection<SimulatorCircuitLayoutEntity> simulatorCircuitLayoutsBySimulatorId;
    @OneToMany(mappedBy = "simulatorBySimulatorId")
    private Collection<SimulatorCountryEntity> simulatorCountriesBySimulatorId;
    @OneToMany(mappedBy = "simulatorBySimulatorId")
    private Collection<SimulatorCupCategoryEntity> simulatorCupCategoriesBySimulatorId;
    @OneToMany(mappedBy = "simulatorBySimulatorId")
    private Collection<SimulatorLicenseEntity> simulatorLicensesBySimulatorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulatorEntity that = (SimulatorEntity) o;
        return simulatorId == that.simulatorId && active == that.active && Objects.equals(name, that.name) && Objects.equals(abbr, that.abbr) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(producer, that.producer) && Objects.equals(logoUrl, that.logoUrl) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simulatorId, name, abbr, releaseDate, producer, logoUrl, active, deletedAt, createdAt, updatedAt);
    }

    public Collection<ChampionshipEntity> getChampionshipsBySimulatorId() {
        return championshipsBySimulatorId;
    }

    public void setChampionshipsBySimulatorId(Collection<ChampionshipEntity> championshipsBySimulatorId) {
        this.championshipsBySimulatorId = championshipsBySimulatorId;
    }

    public Collection<LiveryEntity> getLiveriesBySimulatorId() {
        return liveriesBySimulatorId;
    }

    public void setLiveriesBySimulatorId(Collection<LiveryEntity> liveriesBySimulatorId) {
        this.liveriesBySimulatorId = liveriesBySimulatorId;
    }

    public Collection<SimulatorCarEntity> getSimulatorCarsBySimulatorId() {
        return simulatorCarsBySimulatorId;
    }

    public void setSimulatorCarsBySimulatorId(Collection<SimulatorCarEntity> simulatorCarsBySimulatorId) {
        this.simulatorCarsBySimulatorId = simulatorCarsBySimulatorId;
    }

    public Collection<SimulatorCarCategoryEntity> getSimulatorCarCategoriesBySimulatorId() {
        return simulatorCarCategoriesBySimulatorId;
    }

    public void setSimulatorCarCategoriesBySimulatorId(Collection<SimulatorCarCategoryEntity> simulatorCarCategoriesBySimulatorId) {
        this.simulatorCarCategoriesBySimulatorId = simulatorCarCategoriesBySimulatorId;
    }

    public Collection<SimulatorCircuitLayoutEntity> getSimulatorCircuitLayoutsBySimulatorId() {
        return simulatorCircuitLayoutsBySimulatorId;
    }

    public void setSimulatorCircuitLayoutsBySimulatorId(Collection<SimulatorCircuitLayoutEntity> simulatorCircuitLayoutsBySimulatorId) {
        this.simulatorCircuitLayoutsBySimulatorId = simulatorCircuitLayoutsBySimulatorId;
    }

    public Collection<SimulatorCountryEntity> getSimulatorCountriesBySimulatorId() {
        return simulatorCountriesBySimulatorId;
    }

    public void setSimulatorCountriesBySimulatorId(Collection<SimulatorCountryEntity> simulatorCountriesBySimulatorId) {
        this.simulatorCountriesBySimulatorId = simulatorCountriesBySimulatorId;
    }

    public Collection<SimulatorCupCategoryEntity> getSimulatorCupCategoriesBySimulatorId() {
        return simulatorCupCategoriesBySimulatorId;
    }

    public void setSimulatorCupCategoriesBySimulatorId(Collection<SimulatorCupCategoryEntity> simulatorCupCategoriesBySimulatorId) {
        this.simulatorCupCategoriesBySimulatorId = simulatorCupCategoriesBySimulatorId;
    }

    public Collection<SimulatorLicenseEntity> getSimulatorLicensesBySimulatorId() {
        return simulatorLicensesBySimulatorId;
    }

    public void setSimulatorLicensesBySimulatorId(Collection<SimulatorLicenseEntity> simulatorLicensesBySimulatorId) {
        this.simulatorLicensesBySimulatorId = simulatorLicensesBySimulatorId;
    }
}
