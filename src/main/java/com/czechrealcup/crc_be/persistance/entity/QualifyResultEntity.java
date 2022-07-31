package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
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
    private QualificationEntity qualification;

    @ManyToOne
    @JoinColumn(name = "participation_id", referencedColumnName = "participation_id", nullable = false)
    private ParticipationEntity participation;

    @ManyToOne
    @JoinColumn(name = "penalty_flag_id", referencedColumnName = "penalty_flag_id")
    private PenaltyFlagEntity penaltyFlag;

    @OneToMany(mappedBy = "qualifyResult")
    private Collection<QualifyResultPenalizationEntity> qualifyResultPenalizations;
}
