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
@Table(name = "championship", schema = "crc_db")
public class ChampionshipEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "championship_id", nullable = false)
    private long championshipId;

    @Basic
    @Column(name = "points_best_lap", nullable = false)
    private int pointsBestLap;

    @Basic
    @Column(name = "points_q_won", nullable = false)
    private int pointsQWon;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "public", nullable = false)
    private byte published;

    @Basic
    @Column(name = "published_at")
    private Timestamp publishedAt;

    @Basic
    @Column(name = "open", nullable = false)
    private byte open;

    @Basic
    @Column(name = "open_at")
    private Timestamp openAt;

    @Basic
    @Column(name = "close_at")
    private Timestamp closeAt;

    @Basic
    @Column(name = "highlight", nullable = false)
    private byte highlight;

    @Basic
    @Column(name = "results_calc", nullable = false)
    private byte resultsCalc;

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
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "season_id", nullable = false)
    private SeasonEntity season;

    @ManyToOne
    @JoinColumn(name = "series_id", referencedColumnName = "series_id", nullable = false)
    private SeriesEntity series;

    @ManyToOne
    @JoinColumn(name = "simulator_id", referencedColumnName = "simulator_id", nullable = false)
    private SimulatorEntity simulator;

    @ManyToOne
    @JoinColumn(name = "point_table_id", referencedColumnName = "point_table_id")
    private PointTableEntity pointTable;

    @OneToMany(mappedBy = "championship")
    private Collection<OrganizingEntity> organizings;

    @OneToMany(mappedBy = "championship")
    private Collection<ParticipationEntity> participations;

    @OneToMany(mappedBy = "championship")
    private Collection<RaceCategoryEntity> raceCategories;

    @OneToMany(mappedBy = "championship")
    private Collection<SetEntity> sets;

    @OneToMany(mappedBy = "championship")
    private Collection<TeamParticipationEntity> teamParticipations;
}
