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
    @OneToMany(mappedBy = "teamParticipationByTeamParticipationId")
    private Collection<ParticipationEntity> participationsByTeamParticipationId;
    @ManyToOne
    @JoinColumn(name = "championship_id", referencedColumnName = "championship_id")
    private ChampionshipEntity championshipByChampionshipId;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private TeamEntity teamByTeamId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamParticipationEntity that = (TeamParticipationEntity) o;
        return teamParticipationId == that.teamParticipationId && Objects.equals(name, that.name) && Objects.equals(resPosition, that.resPosition) && Objects.equals(resPoints, that.resPoints) && Objects.equals(confirmed, that.confirmed) && Objects.equals(active, that.active) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamParticipationId, name, resPosition, resPoints, confirmed, active, deletedAt, createdAt, updatedAt);
    }

    public Collection<ParticipationEntity> getParticipationsByTeamParticipationId() {
        return participationsByTeamParticipationId;
    }

    public void setParticipationsByTeamParticipationId(Collection<ParticipationEntity> participationsByTeamParticipationId) {
        this.participationsByTeamParticipationId = participationsByTeamParticipationId;
    }

    public ChampionshipEntity getChampionshipByChampionshipId() {
        return championshipByChampionshipId;
    }

    public void setChampionshipByChampionshipId(ChampionshipEntity championshipByChampionshipId) {
        this.championshipByChampionshipId = championshipByChampionshipId;
    }

    public TeamEntity getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(TeamEntity teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }
}
