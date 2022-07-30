package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "qualify_result", schema = "crc_db", catalog = "")
public class QualifyResultEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "qualify_result_id", nullable = false)
    private long qualifyResultId;
    @Basic
    @Column(name = "best_lap", nullable = false)
    private Time bestLap;
    @Basic
    @Column(name = "laps_completed", nullable = false)
    private int lapsCompleted;
    @Basic
    @Column(name = "res_position", nullable = true)
    private Integer resPosition;
    @Basic
    @Column(name = "note", nullable = true, length = -1)
    private String note;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "qualification_id", referencedColumnName = "qualification_id", nullable = false)
    private QualificationEntity qualificationByQualificationId;
    @ManyToOne
    @JoinColumn(name = "participation_id", referencedColumnName = "participation_id", nullable = false)
    private ParticipationEntity participationByParticipationId;
    @ManyToOne
    @JoinColumn(name = "penalty_flag_id", referencedColumnName = "penalty_flag_id")
    private PenaltyFlagEntity penaltyFlagByPenaltyFlagId;
    @OneToMany(mappedBy = "qualifyResultByQualifyResultId")
    private Collection<QualifyResultPenalizationEntity> qualifyResultPenalizationsByQualifyResultId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QualifyResultEntity that = (QualifyResultEntity) o;
        return qualifyResultId == that.qualifyResultId && lapsCompleted == that.lapsCompleted && Objects.equals(bestLap, that.bestLap) && Objects.equals(resPosition, that.resPosition) && Objects.equals(note, that.note) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifyResultId, bestLap, lapsCompleted, resPosition, note, deletedAt, createdAt, updatedAt);
    }

    public QualificationEntity getQualificationByQualificationId() {
        return qualificationByQualificationId;
    }

    public void setQualificationByQualificationId(QualificationEntity qualificationByQualificationId) {
        this.qualificationByQualificationId = qualificationByQualificationId;
    }

    public ParticipationEntity getParticipationByParticipationId() {
        return participationByParticipationId;
    }

    public void setParticipationByParticipationId(ParticipationEntity participationByParticipationId) {
        this.participationByParticipationId = participationByParticipationId;
    }

    public PenaltyFlagEntity getPenaltyFlagByPenaltyFlagId() {
        return penaltyFlagByPenaltyFlagId;
    }

    public void setPenaltyFlagByPenaltyFlagId(PenaltyFlagEntity penaltyFlagByPenaltyFlagId) {
        this.penaltyFlagByPenaltyFlagId = penaltyFlagByPenaltyFlagId;
    }

    public Collection<QualifyResultPenalizationEntity> getQualifyResultPenalizationsByQualifyResultId() {
        return qualifyResultPenalizationsByQualifyResultId;
    }

    public void setQualifyResultPenalizationsByQualifyResultId(Collection<QualifyResultPenalizationEntity> qualifyResultPenalizationsByQualifyResultId) {
        this.qualifyResultPenalizationsByQualifyResultId = qualifyResultPenalizationsByQualifyResultId;
    }
}
