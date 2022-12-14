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
@Table(name = "set", schema = "crc_db")
public class SetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "set_id", nullable = false)
    private long setId;

    @Basic
    @Column(name = "set_no", nullable = false)
    private int setNo;

    @Basic
    @Column(name = "res_updated", nullable = false)
    private byte resUpdated;

    @Basic
    @Column(name = "res_locked")
    private Byte resLocked;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "set")
    private Collection<CarClassEntity> carClasses;

    @OneToMany(mappedBy = "set")
    private Collection<RaceEntity> races;

    @ManyToOne
    @JoinColumn(name = "championship_id", referencedColumnName = "championship_id", nullable = false)
    private ChampionshipEntity championship;
}
