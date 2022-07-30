package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "practice", schema = "crc_db", catalog = "")
public class PracticeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "practice_id", nullable = false)
    private long practiceId;
    @Basic
    @Column(name = "practice_no", nullable = false)
    private int practiceNo;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "time", nullable = false)
    private Time time;
    @Basic
    @Column(name = "ingame_start", nullable = false)
    private Timestamp ingameStart;
    @Basic
    @Column(name = "dur_time", nullable = false)
    private Time durTime;
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
    private RaceEntity raceByRaceId;
    @OneToMany(mappedBy = "practiceByPracticeId")
    private Collection<PracticeResultEntity> practiceResultsByPracticeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeEntity that = (PracticeEntity) o;
        return practiceId == that.practiceId && practiceNo == that.practiceNo && Objects.equals(name, that.name) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(ingameStart, that.ingameStart) && Objects.equals(durTime, that.durTime) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(practiceId, practiceNo, name, date, time, ingameStart, durTime, deletedAt, createdAt, updatedAt);
    }

    public RaceEntity getRaceByRaceId() {
        return raceByRaceId;
    }

    public void setRaceByRaceId(RaceEntity raceByRaceId) {
        this.raceByRaceId = raceByRaceId;
    }

    public Collection<PracticeResultEntity> getPracticeResultsByPracticeId() {
        return practiceResultsByPracticeId;
    }

    public void setPracticeResultsByPracticeId(Collection<PracticeResultEntity> practiceResultsByPracticeId) {
        this.practiceResultsByPracticeId = practiceResultsByPracticeId;
    }
}
