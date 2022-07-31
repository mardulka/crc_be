package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "simulator_circuit_layout", schema = "crc_db")
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
    @Column(name = "sim_circ_des", length = 128)
    private String simCircDes;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "simulator_id", referencedColumnName = "simulator_id", nullable = false, insertable = false, updatable = false)
    private SimulatorEntity simulator;

    @ManyToOne
    @JoinColumn(name = "circuit_layout_id", referencedColumnName = "circuit_layout_id", nullable = false, insertable = false, updatable = false)
    private CircuitLayoutEntity circuitLayout;
}
