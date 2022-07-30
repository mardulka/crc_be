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
@Table(name = "report", schema = "crc_db", catalog = "")
public class ReportEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "report_id", nullable = false)
    private long reportId;
    @Basic
    @Column(name = "reported_by", nullable = true)
    private Long reportedBy;
    @Basic
    @Column(name = "designation", nullable = false, length = 255)
    private String designation;
    @Basic
    @Column(name = "report_text", nullable = true, length = -1)
    private String reportText;
    @Basic
    @Column(name = "incident_lap", nullable = false)
    private int incidentLap;
    @Basic
    @Column(name = "official_replay", nullable = false)
    private byte officialReplay;
    @Basic
    @Column(name = "official_replay_time", nullable = true)
    private Time officialReplayTime;
    @Basic
    @Column(name = "verdict", nullable = true, length = -1)
    private String verdict;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @OneToMany(mappedBy = "reportByReportId")
    private Collection<RaceResultPenalizationEntity> raceResultPenalizationsByReportId;
    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
    private RaceEntity raceByRaceId;
    @ManyToOne
    @JoinColumn(name = "reported_driver", referencedColumnName = "participation_id")
    private ParticipationEntity participationByReportedDriver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportEntity that = (ReportEntity) o;
        return reportId == that.reportId && incidentLap == that.incidentLap && officialReplay == that.officialReplay && Objects.equals(reportedBy, that.reportedBy) && Objects.equals(designation, that.designation) && Objects.equals(reportText, that.reportText) && Objects.equals(officialReplayTime, that.officialReplayTime) && Objects.equals(verdict, that.verdict) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, reportedBy, designation, reportText, incidentLap, officialReplay, officialReplayTime, verdict, deletedAt, updatedAt, createdAt);
    }

    public Collection<RaceResultPenalizationEntity> getRaceResultPenalizationsByReportId() {
        return raceResultPenalizationsByReportId;
    }

    public void setRaceResultPenalizationsByReportId(Collection<RaceResultPenalizationEntity> raceResultPenalizationsByReportId) {
        this.raceResultPenalizationsByReportId = raceResultPenalizationsByReportId;
    }

    public RaceEntity getRaceByRaceId() {
        return raceByRaceId;
    }

    public void setRaceByRaceId(RaceEntity raceByRaceId) {
        this.raceByRaceId = raceByRaceId;
    }

    public ParticipationEntity getParticipationByReportedDriver() {
        return participationByReportedDriver;
    }

    public void setParticipationByReportedDriver(ParticipationEntity participationByReportedDriver) {
        this.participationByReportedDriver = participationByReportedDriver;
    }
}
