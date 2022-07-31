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
@Table(name = "livery", schema = "crc_db")
public class LiveryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "livery_id", nullable = false)
    private long liveryId;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "number")
    private Integer number;

    @Basic
    @Column(name = "custom", nullable = false)
    private byte custom;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "livery")
    private Collection<ApplicationEntity> applications;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private UserEntity owner;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id", nullable = false)
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "simulator_id", referencedColumnName = "simulator_id")
    private SimulatorEntity simulator;
}
