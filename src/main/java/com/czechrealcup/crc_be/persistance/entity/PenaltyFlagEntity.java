package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "penalty_flag", schema = "crc_db", catalog = "")
public class PenaltyFlagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "penalty_flag_id", nullable = false)
    private long penaltyFlagId;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;

    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "penaltyFlag")
    private Collection<PracticeResultEntity> practiceResults;

    @OneToMany(mappedBy = "penaltyFlag")
    private Collection<QualifyResultEntity> qualifyResults;

    @OneToMany(mappedBy = "penaltyFlag")
    private Collection<RaceResultEntity> raceResults;
}
