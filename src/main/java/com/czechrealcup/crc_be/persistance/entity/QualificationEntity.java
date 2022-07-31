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
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "qualification", schema = "crc_db", catalog = "")
public class QualificationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "qualification_id", nullable = false)
    private long qualificationId;

    @Basic
    @Column(name = "qualification_no", nullable = false)
    private int qualificationNo;

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
    private Timestamp inGameStart;

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
    private RaceEntity race;

    @OneToMany(mappedBy = "qualification")
    private Collection<QualifyResultEntity> qualifyResults;
}
