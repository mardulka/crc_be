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
@Table(name = "participation", schema = "crc_db", catalog = "")
public class ParticipationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "participation_id", nullable = false)
    private long participationId;
    @Basic
    @Column(name = "driver_first_name", nullable = true, length = 32)
    private String driverFirstName;
    @Basic
    @Column(name = "driver_last_name", nullable = true, length = 32)
    private String driverLastName;
    @Basic
    @Column(name = "driver_short_name", nullable = true, length = 3)
    private String driverShortName;
    @Basic
    @Column(name = "car_no", nullable = false)
    private int carNo;
    @Basic
    @Column(name = "confirmed", nullable = false)
    private byte confirmed;
    @Basic
    @Column(name = "active", nullable = false)
    private byte active;
    @Basic
    @Column(name = "res_position", nullable = true)
    private Integer resPosition;
    @Basic
    @Column(name = "res_points", nullable = false)
    private int resPoints;
    @Basic
    @Column(name = "res_class_position", nullable = true)
    private Integer resClassPosition;
    @Basic
    @Column(name = "res_class_points", nullable = true)
    private Integer resClassPoints;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "participation")
    private Collection<ApplicationEntity> applicationsByParticipationId;
    @ManyToOne
    @JoinColumn(name = "championship_id", referencedColumnName = "championship_id", nullable = false)
    private ChampionshipEntity championshipByChampionshipId;
    @ManyToOne
    @JoinColumn(name = "team_participation_id", referencedColumnName = "team_participation_id")
    private TeamParticipationEntity teamParticipationByTeamParticipationId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "crew_id", referencedColumnName = "crew_id")
    private CrewEntity crewByCrewId;
    @OneToMany(mappedBy = "participationByParticipationId")
    private Collection<PracticeResultEntity> practiceResultsByParticipationId;
    @OneToMany(mappedBy = "participationByParticipationId")
    private Collection<QualifyResultEntity> qualifyResultsByParticipationId;
    @OneToMany(mappedBy = "participationByParticipationId")
    private Collection<RaceResultEntity> raceResultsByParticipationId;
    @OneToMany(mappedBy = "participationByReportedDriver")
    private Collection<ReportEntity> reportsByParticipationId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipationEntity that = (ParticipationEntity) o;
        return participationId == that.participationId && carNo == that.carNo && confirmed == that.confirmed && active == that.active && resPoints == that.resPoints && Objects.equals(driverFirstName, that.driverFirstName) && Objects.equals(driverLastName, that.driverLastName) && Objects.equals(driverShortName, that.driverShortName) && Objects.equals(resPosition, that.resPosition) && Objects.equals(resClassPosition, that.resClassPosition) && Objects.equals(resClassPoints, that.resClassPoints) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participationId, driverFirstName, driverLastName, driverShortName, carNo, confirmed, active, resPosition, resPoints, resClassPosition, resClassPoints, deletedAt, createdAt, updatedAt);
    }

    public Collection<ApplicationEntity> getApplicationsByParticipationId() {
        return applicationsByParticipationId;
    }

    public void setApplicationsByParticipationId(Collection<ApplicationEntity> applicationsByParticipationId) {
        this.applicationsByParticipationId = applicationsByParticipationId;
    }

    public ChampionshipEntity getChampionshipByChampionshipId() {
        return championshipByChampionshipId;
    }

    public void setChampionshipByChampionshipId(ChampionshipEntity championshipByChampionshipId) {
        this.championshipByChampionshipId = championshipByChampionshipId;
    }

    public TeamParticipationEntity getTeamParticipationByTeamParticipationId() {
        return teamParticipationByTeamParticipationId;
    }

    public void setTeamParticipationByTeamParticipationId(TeamParticipationEntity teamParticipationByTeamParticipationId) {
        this.teamParticipationByTeamParticipationId = teamParticipationByTeamParticipationId;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public CrewEntity getCrewByCrewId() {
        return crewByCrewId;
    }

    public void setCrewByCrewId(CrewEntity crewByCrewId) {
        this.crewByCrewId = crewByCrewId;
    }

    public Collection<PracticeResultEntity> getPracticeResultsByParticipationId() {
        return practiceResultsByParticipationId;
    }

    public void setPracticeResultsByParticipationId(Collection<PracticeResultEntity> practiceResultsByParticipationId) {
        this.practiceResultsByParticipationId = practiceResultsByParticipationId;
    }

    public Collection<QualifyResultEntity> getQualifyResultsByParticipationId() {
        return qualifyResultsByParticipationId;
    }

    public void setQualifyResultsByParticipationId(Collection<QualifyResultEntity> qualifyResultsByParticipationId) {
        this.qualifyResultsByParticipationId = qualifyResultsByParticipationId;
    }

    public Collection<RaceResultEntity> getRaceResultsByParticipationId() {
        return raceResultsByParticipationId;
    }

    public void setRaceResultsByParticipationId(Collection<RaceResultEntity> raceResultsByParticipationId) {
        this.raceResultsByParticipationId = raceResultsByParticipationId;
    }

    public Collection<ReportEntity> getReportsByParticipationId() {
        return reportsByParticipationId;
    }

    public void setReportsByParticipationId(Collection<ReportEntity> reportsByParticipationId) {
        this.reportsByParticipationId = reportsByParticipationId;
    }
}
