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
@Table(name = "practice_result", schema = "crc_db", catalog = "")
public class PracticeResultEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "practice_result_id", nullable = false)
    private long practiceResultId;
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
    @Column(name = "note", nullable = false, length = -1)
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
    @JoinColumn(name = "practice_id", referencedColumnName = "practice_id", nullable = false)
    private PracticeEntity practiceByPracticeId;
    @ManyToOne
    @JoinColumn(name = "participation_id", referencedColumnName = "participation_id", nullable = false)
    private ParticipationEntity participationByParticipationId;
    @ManyToOne
    @JoinColumn(name = "penalty_flag_id", referencedColumnName = "penalty_flag_id")
    private PenaltyFlagEntity penaltyFlagByPenaltyFlagId;
    @OneToMany(mappedBy = "practiceResultByPracticeResultId")
    private Collection<PracticeResultPenalizationEntity> practiceResultPenalizationsByPracticeResultId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeResultEntity that = (PracticeResultEntity) o;
        return practiceResultId == that.practiceResultId && lapsCompleted == that.lapsCompleted && Objects.equals(bestLap, that.bestLap) && Objects.equals(resPosition, that.resPosition) && Objects.equals(note, that.note) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(practiceResultId, bestLap, lapsCompleted, resPosition, note, deletedAt, createdAt, updatedAt);
    }

    public PracticeEntity getPracticeByPracticeId() {
        return practiceByPracticeId;
    }

    public void setPracticeByPracticeId(PracticeEntity practiceByPracticeId) {
        this.practiceByPracticeId = practiceByPracticeId;
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

    public Collection<PracticeResultPenalizationEntity> getPracticeResultPenalizationsByPracticeResultId() {
        return practiceResultPenalizationsByPracticeResultId;
    }

    public void setPracticeResultPenalizationsByPracticeResultId(Collection<PracticeResultPenalizationEntity> practiceResultPenalizationsByPracticeResultId) {
        this.practiceResultPenalizationsByPracticeResultId = practiceResultPenalizationsByPracticeResultId;
    }
}
