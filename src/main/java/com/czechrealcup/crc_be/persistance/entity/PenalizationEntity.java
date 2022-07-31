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
@Table(name = "penalization", schema = "crc_db")
public class PenalizationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "penalization_id", nullable = false)
    private long penalizationId;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;

    @Basic
    @Column(name = "time_penalty")
    private Time timePenalty;

    @Basic
    @Column(name = "position_penalty")
    private Integer positionPenalty;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "penalization")
    private Collection<PracticeResultPenalizationEntity> practiceResultPenalizations;

    @OneToMany(mappedBy = "penalization")
    private Collection<QualifyResultPenalizationEntity> qualifyResultPenalizations;

    @OneToMany(mappedBy = "penalization")
    private Collection<RaceResultPenalizationEntity> raceResultPenalizations;
}
