package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "simulator_car_category", schema = "crc_db", catalog = "")
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
    private SimulatorEntity simulatorBySimulatorId;
    @ManyToOne
    @JoinColumn(name = "car_category_id", referencedColumnName = "car_category_id", nullable = false, insertable = false, updatable = false)
    private CarCategoryEntity carCategoryByCarCategoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulatorCarCategoryEntity that = (SimulatorCarCategoryEntity) o;
        return simulatorId == that.simulatorId && carCategoryId == that.carCategoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(simulatorId, carCategoryId);
    }

    public SimulatorEntity getSimulatorBySimulatorId() {
        return simulatorBySimulatorId;
    }

    public void setSimulatorBySimulatorId(SimulatorEntity simulatorBySimulatorId) {
        this.simulatorBySimulatorId = simulatorBySimulatorId;
    }

    public CarCategoryEntity getCarCategoryByCarCategoryId() {
        return carCategoryByCarCategoryId;
    }

    public void setCarCategoryByCarCategoryId(CarCategoryEntity carCategoryByCarCategoryId) {
        this.carCategoryByCarCategoryId = carCategoryByCarCategoryId;
    }
}
