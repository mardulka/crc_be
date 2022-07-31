package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "practice_result", schema = "crc_db")
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
    @Column(name = "res_position")
    private Integer resPosition;

    @Basic
    @Column(name = "note", nullable = false, length = -1)
    private String note;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "practice_id", referencedColumnName = "practice_id", nullable = false)
    private PracticeEntity practice;

    @ManyToOne
    @JoinColumn(name = "participation_id", referencedColumnName = "participation_id", nullable = false)
    private ParticipationEntity participation;

    @ManyToOne
    @JoinColumn(name = "penalty_flag_id", referencedColumnName = "penalty_flag_id")
    private PenaltyFlagEntity penaltyFlag;

    @OneToMany(mappedBy = "practiceResult")
    private Collection<PracticeResultPenalizationEntity> practiceResultPenalizations;
}
