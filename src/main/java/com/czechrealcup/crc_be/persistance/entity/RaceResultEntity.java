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
@Table(name = "race_result", schema = "crc_db", catalog = "")
public class RaceResultEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "race_result_id", nullable = false)
    private long raceResultId;

    @Basic
    @Column(name = "init_position", nullable = true)
    private Integer initPosition;

    @Basic
    @Column(name = "res_position", nullable = true)
    private Integer resPosition;

    @Basic
    @Column(name = "points", nullable = true)
    private Integer points;

    @Basic
    @Column(name = "res_class_position", nullable = true)
    private Integer resClassPosition;

    @Basic
    @Column(name = "class_points", nullable = true)
    private Integer classPoints;

    @Basic
    @Column(name = "best_lap", nullable = false)
    private Time bestLap;

    @Basic
    @Column(name = "consistency", nullable = true, precision = 0)
    private Double consistency;

    @Basic
    @Column(name = "laps_completed", nullable = false)
    private int lapsCompleted;

    @Basic
    @Column(name = "pitstops_no", nullable = false)
    private int pitstopsNo;

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
    @JoinColumn(name = "race_id", referencedColumnName = "race_id", nullable = false)
    private RaceEntity race;

    @ManyToOne
    @JoinColumn(name = "participation_id", referencedColumnName = "participation_id", nullable = false)
    private ParticipationEntity participation;

    @ManyToOne
    @JoinColumn(name = "penalty_flag_id", referencedColumnName = "penalty_flag_id")
    private PenaltyFlagEntity penaltyFlag;

    @OneToMany(mappedBy = "raceResult")
    private Collection<RaceResultPenalizationEntity> raceResultPenalizations;
}
