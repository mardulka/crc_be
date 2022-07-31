package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "valuation", schema = "crc_db")
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
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "point_table_id", referencedColumnName = "point_table_id", nullable = false)
    private PointTableEntity pointTable;
}
