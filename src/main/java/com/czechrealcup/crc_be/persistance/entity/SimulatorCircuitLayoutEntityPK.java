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
public class SimulatorCircuitLayoutEntityPK implements Serializable {
    @Column(name = "simulator_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long simulatorId;
    @Column(name = "circuit_layout_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long circuitLayoutId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulatorCircuitLayoutEntityPK that = (SimulatorCircuitLayoutEntityPK) o;
        return simulatorId == that.simulatorId && circuitLayoutId == that.circuitLayoutId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(simulatorId, circuitLayoutId);
    }
}
