package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "race_result_penalization", schema = "crc_db", catalog = "")
public class RaceResultPenalizationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "race_result_penalization_id", nullable = false)
    private long raceResultPenalizationId;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "race_result_id", referencedColumnName = "race_result_id", nullable = false)
    private RaceResultEntity raceResultByRaceResultId;
    @ManyToOne
    @JoinColumn(name = "penalization_id", referencedColumnName = "penalization_id", nullable = false)
    private PenalizationEntity penalizationByPenalizationId;
    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "report_id")
    private ReportEntity reportByReportId;

    public long getRaceResultPenalizationId() {
        return raceResultPenalizationId;
    }

    public void setRaceResultPenalizationId(long raceResultPenalizationId) {
        this.raceResultPenalizationId = raceResultPenalizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceResultPenalizationEntity that = (RaceResultPenalizationEntity) o;
        return raceResultPenalizationId == that.raceResultPenalizationId && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceResultPenalizationId, createdAt, updatedAt);
    }

    public RaceResultEntity getRaceResultByRaceResultId() {
        return raceResultByRaceResultId;
    }

    public void setRaceResultByRaceResultId(RaceResultEntity raceResultByRaceResultId) {
        this.raceResultByRaceResultId = raceResultByRaceResultId;
    }

    public PenalizationEntity getPenalizationByPenalizationId() {
        return penalizationByPenalizationId;
    }

    public void setPenalizationByPenalizationId(PenalizationEntity penalizationByPenalizationId) {
        this.penalizationByPenalizationId = penalizationByPenalizationId;
    }

    public ReportEntity getReportByReportId() {
        return reportByReportId;
    }

    public void setReportByReportId(ReportEntity reportByReportId) {
        this.reportByReportId = reportByReportId;
    }
}
