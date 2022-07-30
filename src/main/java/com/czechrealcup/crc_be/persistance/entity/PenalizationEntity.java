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
@Table(name = "penalization", schema = "crc_db", catalog = "")
public class PenalizationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "penalization_id", nullable = false)
    private long penalizationId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "time_penalty", nullable = true)
    private Time timePenalty;
    @Basic
    @Column(name = "position_penalty", nullable = true)
    private Integer positionPenalty;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "penalizationByPenalizationId")
    private Collection<PracticeResultPenalizationEntity> practiceResultPenalizationsByPenalizationId;
    @OneToMany(mappedBy = "penalizationByPenalizationId")
    private Collection<QualifyResultPenalizationEntity> qualifyResultPenalizationsByPenalizationId;
    @OneToMany(mappedBy = "penalizationByPenalizationId")
    private Collection<RaceResultPenalizationEntity> raceResultPenalizationsByPenalizationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PenalizationEntity that = (PenalizationEntity) o;
        return penalizationId == that.penalizationId && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(timePenalty, that.timePenalty) && Objects.equals(positionPenalty, that.positionPenalty) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(penalizationId, name, description, timePenalty, positionPenalty, deletedAt, createdAt, updatedAt);
    }

    public Collection<PracticeResultPenalizationEntity> getPracticeResultPenalizationsByPenalizationId() {
        return practiceResultPenalizationsByPenalizationId;
    }

    public void setPracticeResultPenalizationsByPenalizationId(Collection<PracticeResultPenalizationEntity> practiceResultPenalizationsByPenalizationId) {
        this.practiceResultPenalizationsByPenalizationId = practiceResultPenalizationsByPenalizationId;
    }

    public Collection<QualifyResultPenalizationEntity> getQualifyResultPenalizationsByPenalizationId() {
        return qualifyResultPenalizationsByPenalizationId;
    }

    public void setQualifyResultPenalizationsByPenalizationId(Collection<QualifyResultPenalizationEntity> qualifyResultPenalizationsByPenalizationId) {
        this.qualifyResultPenalizationsByPenalizationId = qualifyResultPenalizationsByPenalizationId;
    }

    public Collection<RaceResultPenalizationEntity> getRaceResultPenalizationsByPenalizationId() {
        return raceResultPenalizationsByPenalizationId;
    }

    public void setRaceResultPenalizationsByPenalizationId(Collection<RaceResultPenalizationEntity> raceResultPenalizationsByPenalizationId) {
        this.raceResultPenalizationsByPenalizationId = raceResultPenalizationsByPenalizationId;
    }
}
