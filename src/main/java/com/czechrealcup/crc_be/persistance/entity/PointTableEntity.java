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
@Table(name = "point_table", schema = "crc_db", catalog = "")
public class PointTableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "point_table_id", nullable = false)
    private long pointTableId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "active", nullable = false)
    private byte active;
    @Basic
    @Column(name = "locked", nullable = false)
    private byte locked;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "pointTable")
    private Collection<ChampionshipEntity> championshipsByPointTableId;
    @OneToMany(mappedBy = "pointTableByPointTableId")
    private Collection<ValuationEntity> valuationsByPointTableId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointTableEntity that = (PointTableEntity) o;
        return pointTableId == that.pointTableId && active == that.active && locked == that.locked && Objects.equals(name, that.name) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointTableId, name, active, locked, deletedAt, createdAt, updatedAt);
    }

    public Collection<ChampionshipEntity> getChampionshipsByPointTableId() {
        return championshipsByPointTableId;
    }

    public void setChampionshipsByPointTableId(Collection<ChampionshipEntity> championshipsByPointTableId) {
        this.championshipsByPointTableId = championshipsByPointTableId;
    }

    public Collection<ValuationEntity> getValuationsByPointTableId() {
        return valuationsByPointTableId;
    }

    public void setValuationsByPointTableId(Collection<ValuationEntity> valuationsByPointTableId) {
        this.valuationsByPointTableId = valuationsByPointTableId;
    }
}
