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
@Table(name = "report", schema = "crc_db")
public class ReportEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "report_id", nullable = false)
    private long reportId;

    @Basic
    @Column(name = "reported_by")
    private Long reportedBy;

    @Basic
    @Column(name = "designation", nullable = false)
    private String designation;

    @Basic
    @Column(name = "report_text", length = -1)
    private String reportText;

    @Basic
    @Column(name = "incident_lap", nullable = false)
    private int incidentLap;

    @Basic
    @Column(name = "official_replay", nullable = false)
    private byte officialReplay;

    @Basic
    @Column(name = "official_replay_time")
    private Time officialReplayTime;

    @Basic
    @Column(name = "verdict", length = -1)
    private String verdict;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToMany(mappedBy = "report")
    private Collection<RaceResultPenalizationEntity> raceResultPenalizations;

    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
    private RaceEntity race;

    @ManyToOne
    @JoinColumn(name = "reported_driver", referencedColumnName = "participation_id")
    private ParticipationEntity participation;
}
