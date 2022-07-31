package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "simulator_car_category", schema = "crc_db")
@IdClass(SimulatorCarCategoryEntityPK.class)
public class SimulatorCarCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "simulator_id", nullable = false)
    private long simulatorId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "car_category_id", nullable = false)
    private long carCategoryId;

    @ManyToOne
    @JoinColumn(name = "simulator_id", referencedColumnName = "simulator_id", nullable = false, insertable = false, updatable = false)
    private SimulatorEntity simulator;

    @ManyToOne
    @JoinColumn(name = "car_category_id", referencedColumnName = "car_category_id", nullable = false, insertable = false, updatable = false)
    private CarCategoryEntity carCategory;
}
