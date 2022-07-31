package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "team_participation", schema = "crc_db", catalog = "")
public class TeamParticipationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "team_participation_id", nullable = false)
    private long teamParticipationId;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Basic
    @Column(name = "res_position", nullable = true)
    private Integer resPosition;

    @Basic
    @Column(name = "res_points", nullable = true)
    private Integer resPoints;

    @Basic
    @Column(name = "confirmed", nullable = true)
    private Byte confirmed;

    @Basic
    @Column(name = "active", nullable = true)
    private Byte active;

    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "teamParticipation")
    private Collection<ParticipationEntity> participations;

    @ManyToOne
    @JoinColumn(name = "championship_id", referencedColumnName = "championship_id")
    private ChampionshipEntity championship;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private TeamEntity team;
}
