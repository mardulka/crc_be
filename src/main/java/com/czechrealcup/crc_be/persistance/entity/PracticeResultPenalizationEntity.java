package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "practice_result_penalization", schema = "crc_db", catalog = "")
@IdClass(PracticeResultPenalizationEntityPK.class)
public class PracticeResultPenalizationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "practice_result_id", nullable = false)
    private long practiceResultId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "penalization_id", nullable = false)
    private long penalizationId;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "practice_result_id", referencedColumnName = "practice_result_id", nullable = false, insertable = false, updatable = false)
    private PracticeResultEntity practiceResultByPracticeResultId;
    @ManyToOne
    @JoinColumn(name = "penalization_id", referencedColumnName = "penalization_id", nullable = false, insertable = false, updatable = false)
    private PenalizationEntity penalizationByPenalizationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeResultPenalizationEntity that = (PracticeResultPenalizationEntity) o;
        return practiceResultId == that.practiceResultId && penalizationId == that.penalizationId && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(practiceResultId, penalizationId, createdAt, updatedAt);
    }

    public PracticeResultEntity getPracticeResultByPracticeResultId() {
        return practiceResultByPracticeResultId;
    }

    public void setPracticeResultByPracticeResultId(PracticeResultEntity practiceResultByPracticeResultId) {
        this.practiceResultByPracticeResultId = practiceResultByPracticeResultId;
    }

    public PenalizationEntity getPenalizationByPenalizationId() {
        return penalizationByPenalizationId;
    }

    public void setPenalizationByPenalizationId(PenalizationEntity penalizationByPenalizationId) {
        this.penalizationByPenalizationId = penalizationByPenalizationId;
    }
}
