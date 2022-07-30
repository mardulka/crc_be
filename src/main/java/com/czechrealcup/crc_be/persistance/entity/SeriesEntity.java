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
@Table(name = "series", schema = "crc_db", catalog = "")
public class SeriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "series_id", nullable = false)
    private long seriesId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
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
    @OneToMany(mappedBy = "series")
    private Collection<ChampionshipEntity> championshipsBySeriesId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriesEntity that = (SeriesEntity) o;
        return seriesId == that.seriesId && active == that.active && Objects.equals(name, that.name) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriesId, name, active, deletedAt, createdAt, updatedAt);
    }

    public Collection<ChampionshipEntity> getChampionshipsBySeriesId() {
        return championshipsBySeriesId;
    }

    public void setChampionshipsBySeriesId(Collection<ChampionshipEntity> championshipsBySeriesId) {
        this.championshipsBySeriesId = championshipsBySeriesId;
    }
}
