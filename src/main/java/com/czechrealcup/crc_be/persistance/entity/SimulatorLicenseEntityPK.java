package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class SimulatorLicenseEntityPK implements Serializable {
    @Column(name = "simulator_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long simulatorId;
    @Column(name = "license_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long licenseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulatorLicenseEntityPK that = (SimulatorLicenseEntityPK) o;
        return simulatorId == that.simulatorId && licenseId == that.licenseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(simulatorId, licenseId);
    }
}
