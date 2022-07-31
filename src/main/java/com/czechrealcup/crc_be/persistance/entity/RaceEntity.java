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
@Table(name = "race", schema = "crc_db")
public class RaceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "race_id", nullable = false)
    private long raceId;

    @Basic
    @Column(name = "race_no", nullable = false)
    private int raceNo;

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
    private Timestamp ingameStart;

    @Basic
    @Column(name = "dur_time")
    private Time durTime;

    @Basic
    @Column(name = "dur_laps")
    private Integer durLaps;

    @Basic
    @Column(name = "mand_pits", nullable = false)
    private int mandPits;

    @Basic
    @Column(name = "mand_wheels", nullable = false)
    private byte mandWheels;

    @Basic
    @Column(name = "mand_refuel", nullable = false)
    private byte mandRefuel;

    @Basic
    @Column(name = "weather", nullable = false, length = -1)
    private String weather;

    @Basic
    @Column(name = "res_updated", nullable = false)
    private byte resUpdated;

    @Basic
    @Column(name = "res_locked", nullable = false)
    private byte resLocked;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "race")
    private Collection<PracticeEntity> practices;

    @OneToMany(mappedBy = "race")
    private Collection<QualificationEntity> qualifications;

    @ManyToOne
    @JoinColumn(name = "set_id", referencedColumnName = "set_id", nullable = false)
    private SetEntity set;

    @ManyToOne
    @JoinColumn(name = "circuit_layout_id", referencedColumnName = "circuit_layout_id", nullable = false)
    private CircuitLayoutEntity circuitLayout;

    @OneToMany(mappedBy = "race")
    private Collection<RaceResultEntity> raceResults;

    @OneToMany(mappedBy = "race")
    private Collection<ReportEntity> reports;

    @OneToMany(mappedBy = "race")
    private Collection<ServerConfigEntity> serverConfigs;
}
