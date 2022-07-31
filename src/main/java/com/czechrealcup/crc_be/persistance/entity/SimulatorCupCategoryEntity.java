package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "simulator_cup_category", schema = "crc_db", catalog = "")
@IdClass(SimulatorCupCategoryEntityPK.class)
public class SimulatorCupCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cup_category_id", nullable = false)
    private long cupCategoryId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "simulator_id", nullable = false)
    private long simulatorId;

    @Basic
    @Column(name = "sim_cup_categ_id", nullable = true)
    private Long simCupCategId;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "cup_category_id", referencedColumnName = "cup_category_id", nullable = false, insertable = false, updatable = false)
    private CupCategoryEntity cupCategory;

    @ManyToOne
    @JoinColumn(name = "simulator_id", referencedColumnName = "simulator_id", nullable = false, insertable = false, updatable = false)
    private SimulatorEntity simulator;
}
