package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "simulator_license", schema = "crc_db", catalog = "")
@IdClass(SimulatorLicenseEntityPK.class)
public class SimulatorLicenseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "simulator_id", nullable = false)
    private long simulatorId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "license_id", nullable = false)
    private long licenseId;
    @Basic
    @Column(name = "sim_license_id", nullable = true)
    private Integer simLicenseId;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "simulator_id", referencedColumnName = "simulator_id", nullable = false, insertable = false, updatable = false)
    private SimulatorEntity simulatorBySimulatorId;
    @ManyToOne
    @JoinColumn(name = "license_id", referencedColumnName = "license_id", nullable = false, insertable = false, updatable = false)
    private LicenseEntity licenseByLicenseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulatorLicenseEntity that = (SimulatorLicenseEntity) o;
        return simulatorId == that.simulatorId && licenseId == that.licenseId && Objects.equals(simLicenseId, that.simLicenseId) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simulatorId, licenseId, simLicenseId, createdAt, updatedAt);
    }

    public SimulatorEntity getSimulatorBySimulatorId() {
        return simulatorBySimulatorId;
    }

    public void setSimulatorBySimulatorId(SimulatorEntity simulatorBySimulatorId) {
        this.simulatorBySimulatorId = simulatorBySimulatorId;
    }

    public LicenseEntity getLicenseByLicenseId() {
        return licenseByLicenseId;
    }

    public void setLicenseByLicenseId(LicenseEntity licenseByLicenseId) {
        this.licenseByLicenseId = licenseByLicenseId;
    }
}
