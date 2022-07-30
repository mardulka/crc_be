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
public class PracticeResultPenalizationEntityPK implements Serializable {
    @Column(name = "practice_result_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long practiceResultId;
    @Column(name = "penalization_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long penalizationId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeResultPenalizationEntityPK that = (PracticeResultPenalizationEntityPK) o;
        return practiceResultId == that.practiceResultId && penalizationId == that.penalizationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(practiceResultId, penalizationId);
    }
}
