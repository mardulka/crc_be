package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "qualify_result_penalization", schema = "crc_db", catalog = "")
@IdClass(QualifyResultPenalizationEntityPK.class)
public class QualifyResultPenalizationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "qualify_result_id", nullable = false)
    private long qualifyResultId;
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
    @JoinColumn(name = "qualify_result_id", referencedColumnName = "qualify_result_id", nullable = false, insertable = false, updatable = false)
    private QualifyResultEntity qualifyResultByQualifyResultId;
    @ManyToOne
    @JoinColumn(name = "penalization_id", referencedColumnName = "penalization_id", nullable = false, insertable = false, updatable = false)
    private PenalizationEntity penalizationByPenalizationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QualifyResultPenalizationEntity that = (QualifyResultPenalizationEntity) o;
        return qualifyResultId == that.qualifyResultId && penalizationId == that.penalizationId && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifyResultId, penalizationId, createdAt, updatedAt);
    }

    public QualifyResultEntity getQualifyResultByQualifyResultId() {
        return qualifyResultByQualifyResultId;
    }

    public void setQualifyResultByQualifyResultId(QualifyResultEntity qualifyResultByQualifyResultId) {
        this.qualifyResultByQualifyResultId = qualifyResultByQualifyResultId;
    }

    public PenalizationEntity getPenalizationByPenalizationId() {
        return penalizationByPenalizationId;
    }

    public void setPenalizationByPenalizationId(PenalizationEntity penalizationByPenalizationId) {
        this.penalizationByPenalizationId = penalizationByPenalizationId;
    }
}
