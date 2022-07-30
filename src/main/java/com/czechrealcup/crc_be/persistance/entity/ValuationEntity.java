package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "valuation", schema = "crc_db", catalog = "")
public class ValuationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "valuation_id", nullable = false)
    private long valuationId;
    @Basic
    @Column(name = "position", nullable = false)
    private int position;
    @Basic
    @Column(name = "points", nullable = false)
    private int points;
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
    @ManyToOne
    @JoinColumn(name = "point_table_id", referencedColumnName = "point_table_id", nullable = false)
    private PointTableEntity pointTableByPointTableId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValuationEntity that = (ValuationEntity) o;
        return valuationId == that.valuationId && position == that.position && points == that.points && locked == that.locked && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valuationId, position, points, locked, deletedAt, createdAt, updatedAt);
    }

    public PointTableEntity getPointTableByPointTableId() {
        return pointTableByPointTableId;
    }

    public void setPointTableByPointTableId(PointTableEntity pointTableByPointTableId) {
        this.pointTableByPointTableId = pointTableByPointTableId;
    }
}
