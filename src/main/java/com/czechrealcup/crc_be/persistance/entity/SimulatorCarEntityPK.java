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
public class SimulatorCarEntityPK implements Serializable {
    @Column(name = "car_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId;
    @Column(name = "simulator_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long simulatorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulatorCarEntityPK that = (SimulatorCarEntityPK) o;
        return carId == that.carId && simulatorId == that.simulatorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, simulatorId);
    }
}
