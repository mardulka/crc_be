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
@Table(name = "race", schema = "crc_db", catalog = "")
public class RaceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "race_id", nullable = false)
    private long raceId;
    @Basic
    @Column(name = "race_no", nullable = false)
    private int raceNo;
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
    @Column(name = "dur_time", nullable = true)
    private Time durTime;
    @Basic
    @Column(name = "dur_laps", nullable = true)
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
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "raceByRaceId")
    private Collection<PracticeEntity> practicesByRaceId;
    @OneToMany(mappedBy = "raceByRaceId")
    private Collection<QualificationEntity> qualificationsByRaceId;
    @ManyToOne
    @JoinColumn(name = "set_id", referencedColumnName = "set_id", nullable = false)
    private SetEntity setBySetId;
    @ManyToOne
    @JoinColumn(name = "circuit_layout_id", referencedColumnName = "circuit_layout_id", nullable = false)
    private CircuitLayoutEntity circuitLayoutByCircuitLayoutId;
    @OneToMany(mappedBy = "raceByRaceId")
    private Collection<RaceResultEntity> raceResultsByRaceId;
    @OneToMany(mappedBy = "raceByRaceId")
    private Collection<ReportEntity> reportsByRaceId;
    @OneToMany(mappedBy = "raceByRaceId")
    private Collection<ServerConfigEntity> serverConfigsByRaceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceEntity that = (RaceEntity) o;
        return raceId == that.raceId && raceNo == that.raceNo && mandPits == that.mandPits && mandWheels == that.mandWheels && mandRefuel == that.mandRefuel && resUpdated == that.resUpdated && resLocked == that.resLocked && Objects.equals(name, that.name) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(ingameStart, that.ingameStart) && Objects.equals(durTime, that.durTime) && Objects.equals(durLaps, that.durLaps) && Objects.equals(weather, that.weather) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId, raceNo, name, date, time, ingameStart, durTime, durLaps, mandPits, mandWheels, mandRefuel, weather, resUpdated, resLocked, deletedAt, createdAt, updatedAt);
    }

    public Collection<PracticeEntity> getPracticesByRaceId() {
        return practicesByRaceId;
    }

    public void setPracticesByRaceId(Collection<PracticeEntity> practicesByRaceId) {
        this.practicesByRaceId = practicesByRaceId;
    }

    public Collection<QualificationEntity> getQualificationsByRaceId() {
        return qualificationsByRaceId;
    }

    public void setQualificationsByRaceId(Collection<QualificationEntity> qualificationsByRaceId) {
        this.qualificationsByRaceId = qualificationsByRaceId;
    }

    public SetEntity getSetBySetId() {
        return setBySetId;
    }

    public void setSetBySetId(SetEntity setBySetId) {
        this.setBySetId = setBySetId;
    }

    public CircuitLayoutEntity getCircuitLayoutByCircuitLayoutId() {
        return circuitLayoutByCircuitLayoutId;
    }

    public void setCircuitLayoutByCircuitLayoutId(CircuitLayoutEntity circuitLayoutByCircuitLayoutId) {
        this.circuitLayoutByCircuitLayoutId = circuitLayoutByCircuitLayoutId;
    }

    public Collection<RaceResultEntity> getRaceResultsByRaceId() {
        return raceResultsByRaceId;
    }

    public void setRaceResultsByRaceId(Collection<RaceResultEntity> raceResultsByRaceId) {
        this.raceResultsByRaceId = raceResultsByRaceId;
    }

    public Collection<ReportEntity> getReportsByRaceId() {
        return reportsByRaceId;
    }

    public void setReportsByRaceId(Collection<ReportEntity> reportsByRaceId) {
        this.reportsByRaceId = reportsByRaceId;
    }

    public Collection<ServerConfigEntity> getServerConfigsByRaceId() {
        return serverConfigsByRaceId;
    }

    public void setServerConfigsByRaceId(Collection<ServerConfigEntity> serverConfigsByRaceId) {
        this.serverConfigsByRaceId = serverConfigsByRaceId;
    }
}
