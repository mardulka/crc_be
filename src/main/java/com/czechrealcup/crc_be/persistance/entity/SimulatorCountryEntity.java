package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "simulator_country", schema = "crc_db", catalog = "")
@IdClass(SimulatorCountryEntityPK.class)
public class SimulatorCountryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id", nullable = false)
    private long countryId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "simulator_id", nullable = false)
    private long simulatorId;
    @Basic
    @Column(name = "sim_country_id", nullable = true)
    private Long simCountryId;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false, insertable = false, updatable = false)
    private CountryEntity countryByCountryId;
    @ManyToOne
    @JoinColumn(name = "simulator_id", referencedColumnName = "simulator_id", nullable = false, insertable = false, updatable = false)
    private SimulatorEntity simulatorBySimulatorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulatorCountryEntity that = (SimulatorCountryEntity) o;
        return countryId == that.countryId && simulatorId == that.simulatorId && Objects.equals(simCountryId, that.simCountryId) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, simulatorId, simCountryId, createdAt, updatedAt);
    }

    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    public SimulatorEntity getSimulatorBySimulatorId() {
        return simulatorBySimulatorId;
    }

    public void setSimulatorBySimulatorId(SimulatorEntity simulatorBySimulatorId) {
        this.simulatorBySimulatorId = simulatorBySimulatorId;
    }
}
