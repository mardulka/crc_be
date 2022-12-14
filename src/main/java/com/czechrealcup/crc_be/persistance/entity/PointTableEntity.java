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
@Table(name = "point_table", schema = "crc_db")
public class PointTableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "point_table_id", nullable = false)
    private long pointTableId;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "active", nullable = false)
    private byte active;

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

    @OneToMany(mappedBy = "pointTable")
    private Collection<ChampionshipEntity> championships;

    @OneToMany(mappedBy = "pointTable")
    private Collection<ValuationEntity> valuations;
}
