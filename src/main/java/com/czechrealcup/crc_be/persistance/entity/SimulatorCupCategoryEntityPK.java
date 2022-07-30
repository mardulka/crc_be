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
public class SimulatorCupCategoryEntityPK implements Serializable {
    @Column(name = "cup_category_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cupCategoryId;
    @Column(name = "simulator_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long simulatorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulatorCupCategoryEntityPK that = (SimulatorCupCategoryEntityPK) o;
        return cupCategoryId == that.cupCategoryId && simulatorId == that.simulatorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cupCategoryId, simulatorId);
    }
}
