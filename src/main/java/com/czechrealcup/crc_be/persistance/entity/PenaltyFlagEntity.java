package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
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
    @OneToMany(mappedBy = "penaltyFlagByPenaltyFlagId")
    private Collection<PracticeResultEntity> practiceResultsByPenaltyFlagId;
    @OneToMany(mappedBy = "penaltyFlagByPenaltyFlagId")
    private Collection<QualifyResultEntity> qualifyResultsByPenaltyFlagId;
    @OneToMany(mappedBy = "penaltyFlagByPenaltyFlagId")
    private Collection<RaceResultEntity> raceResultsByPenaltyFlagId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PenaltyFlagEntity that = (PenaltyFlagEntity) o;
        return penaltyFlagId == that.penaltyFlagId && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(penaltyFlagId, name, description, deletedAt, createdAt, updatedAt);
    }

    public Collection<PracticeResultEntity> getPracticeResultsByPenaltyFlagId() {
        return practiceResultsByPenaltyFlagId;
    }

    public void setPracticeResultsByPenaltyFlagId(Collection<PracticeResultEntity> practiceResultsByPenaltyFlagId) {
        this.practiceResultsByPenaltyFlagId = practiceResultsByPenaltyFlagId;
    }

    public Collection<QualifyResultEntity> getQualifyResultsByPenaltyFlagId() {
        return qualifyResultsByPenaltyFlagId;
    }

    public void setQualifyResultsByPenaltyFlagId(Collection<QualifyResultEntity> qualifyResultsByPenaltyFlagId) {
        this.qualifyResultsByPenaltyFlagId = qualifyResultsByPenaltyFlagId;
    }

    public Collection<RaceResultEntity> getRaceResultsByPenaltyFlagId() {
        return raceResultsByPenaltyFlagId;
    }

    public void setRaceResultsByPenaltyFlagId(Collection<RaceResultEntity> raceResultsByPenaltyFlagId) {
        this.raceResultsByPenaltyFlagId = raceResultsByPenaltyFlagId;
    }
}
