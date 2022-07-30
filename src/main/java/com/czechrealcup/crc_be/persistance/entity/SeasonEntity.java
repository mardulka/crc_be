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
@Table(name = "season", schema = "crc_db", catalog = "")
public class SeasonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "season_id", nullable = false)
    private long seasonId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "order", nullable = false)
    private int order;
    @Basic
    @Column(name = "active", nullable = false)
    private byte active;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "season")
    private Collection<ChampionshipEntity> championshipsBySeasonId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeasonEntity that = (SeasonEntity) o;
        return seasonId == that.seasonId && order == that.order && active == that.active && Objects.equals(name, that.name) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonId, name, order, active, deletedAt, createdAt, updatedAt);
    }

    public Collection<ChampionshipEntity> getChampionshipsBySeasonId() {
        return championshipsBySeasonId;
    }

    public void setChampionshipsBySeasonId(Collection<ChampionshipEntity> championshipsBySeasonId) {
        this.championshipsBySeasonId = championshipsBySeasonId;
    }
}
