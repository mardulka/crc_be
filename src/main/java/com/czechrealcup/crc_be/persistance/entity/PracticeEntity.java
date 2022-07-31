package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "practice", schema = "crc_db")
public class PracticeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "practice_id", nullable = false)
    private long practiceId;

    @Basic
    @Column(name = "practice_no", nullable = false)
    private int practiceNo;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "date", nullable = false)
    private Date date;

    @Basic
    @Column(name = "time", nullable = false)
    private Time time;

    @Basic
    @Column(name = "ingame_start", nullable = false)
    private Timestamp inGameStart;

    @Basic
    @Column(name = "dur_time", nullable = false)
    private Time durTime;

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
    @JoinColumn(name = "race_id", referencedColumnName = "race_id", nullable = false)
    private RaceEntity race;

    @OneToMany(mappedBy = "practice")
    private Collection<PracticeResultEntity> practiceResults;
}
