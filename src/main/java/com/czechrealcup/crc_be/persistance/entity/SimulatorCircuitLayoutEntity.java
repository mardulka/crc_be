package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "simulator_circuit_layout", schema = "crc_db", catalog = "")
@IdClass(SimulatorCircuitLayoutEntityPK.class)
public class SimulatorCircuitLayoutEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "simulator_id", nullable = false)
    private long simulatorId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "circuit_layout_id", nullable = false)
    private long circuitLayoutId;
    @Basic
    @Column(name = "sim_circ_des", nullable = true, length = 128)
    private String simCircDes;
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
    @JoinColumn(name = "circuit_layout_id", referencedColumnName = "circuit_layout_id", nullable = false, insertable = false, updatable = false)
    private CircuitLayoutEntity circuitLayoutByCircuitLayoutId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulatorCircuitLayoutEntity that = (SimulatorCircuitLayoutEntity) o;
        return simulatorId == that.simulatorId && circuitLayoutId == that.circuitLayoutId && Objects.equals(simCircDes, that.simCircDes) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simulatorId, circuitLayoutId, simCircDes, createdAt, updatedAt);
    }

    public SimulatorEntity getSimulatorBySimulatorId() {
        return simulatorBySimulatorId;
    }

    public void setSimulatorBySimulatorId(SimulatorEntity simulatorBySimulatorId) {
        this.simulatorBySimulatorId = simulatorBySimulatorId;
    }

    public CircuitLayoutEntity getCircuitLayoutByCircuitLayoutId() {
        return circuitLayoutByCircuitLayoutId;
    }

    public void setCircuitLayoutByCircuitLayoutId(CircuitLayoutEntity circuitLayoutByCircuitLayoutId) {
        this.circuitLayoutByCircuitLayoutId = circuitLayoutByCircuitLayoutId;
    }
}
