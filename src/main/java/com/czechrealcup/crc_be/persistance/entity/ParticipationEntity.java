package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "participation", schema = "crc_db")
public class ParticipationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "participation_id", nullable = false)
    private long participationId;

    @Basic
    @Column(name = "driver_first_name", length = 32)
    private String driverFirstName;

    @Basic
    @Column(name = "driver_last_name", length = 32)
    private String driverLastName;

    @Basic
    @Column(name = "driver_short_name", length = 3)
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
    @Column(name = "res_position")
    private Integer resPosition;

    @Basic
    @Column(name = "res_points", nullable = false)
    private int resPoints;

    @Basic
    @Column(name = "res_class_position")
    private Integer resClassPosition;

    @Basic
    @Column(name = "res_class_points")
    private Integer resClassPoints;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "participation")
    private Collection<ApplicationEntity> applications;

    @ManyToOne
    @JoinColumn(name = "championship_id", referencedColumnName = "championship_id", nullable = false)
    private ChampionshipEntity championship;

    @ManyToOne
    @JoinColumn(name = "team_participation_id", referencedColumnName = "team_participation_id")
    private TeamParticipationEntity teamParticipation;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "crew_id", referencedColumnName = "crew_id")
    private CrewEntity crew;

    @OneToMany(mappedBy = "participation")
    private Collection<PracticeResultEntity> practiceResults;

    @OneToMany(mappedBy = "participation")
    private Collection<QualifyResultEntity> qualifyResults;

    @OneToMany(mappedBy = "participation")
    private Collection<RaceResultEntity> raceResults;

    @OneToMany(mappedBy = "participation")
    private Collection<ReportEntity> reports;
}