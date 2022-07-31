package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "circuit_layout", schema = "crc_db")
public class CircuitLayoutEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "circuit_layout_id", nullable = false)
    private long circuitLayoutId;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "year", nullable = false)
    private Integer year;

    @Basic
    @Column(name = "map_URL")
    private String mapUrl;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "circuit_id", referencedColumnName = "circuit_id", nullable = false)
    private CircuitEntity circuit;

    @OneToMany(mappedBy = "circuitLayout")
    private Collection<RaceEntity> races;

    @OneToMany(mappedBy = "circuitLayout")
    private Collection<SimulatorCircuitLayoutEntity> simulatorCircuitLayouts;
}
