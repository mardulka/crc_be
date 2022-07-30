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
@Table(name = "set", schema = "crc_db", catalog = "")
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
    @Column(name = "res_locked", nullable = true)
    private Byte resLocked;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "set")
    private Collection<CarClassEntity> carClassesBySetId;
    @OneToMany(mappedBy = "setBySetId")
    private Collection<RaceEntity> racesBySetId;
    @ManyToOne
    @JoinColumn(name = "championship_id", referencedColumnName = "championship_id", nullable = false)
    private ChampionshipEntity championshipByChampionshipId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetEntity setEntity = (SetEntity) o;
        return setId == setEntity.setId && setNo == setEntity.setNo && resUpdated == setEntity.resUpdated && Objects.equals(resLocked, setEntity.resLocked) && Objects.equals(deletedAt, setEntity.deletedAt) && Objects.equals(createdAt, setEntity.createdAt) && Objects.equals(updatedAt, setEntity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(setId, setNo, resUpdated, resLocked, deletedAt, createdAt, updatedAt);
    }

    public Collection<CarClassEntity> getCarClassesBySetId() {
        return carClassesBySetId;
    }

    public void setCarClassesBySetId(Collection<CarClassEntity> carClassesBySetId) {
        this.carClassesBySetId = carClassesBySetId;
    }

    public Collection<RaceEntity> getRacesBySetId() {
        return racesBySetId;
    }

    public void setRacesBySetId(Collection<RaceEntity> racesBySetId) {
        this.racesBySetId = racesBySetId;
    }

    public ChampionshipEntity getChampionshipByChampionshipId() {
        return championshipByChampionshipId;
    }

    public void setChampionshipByChampionshipId(ChampionshipEntity championshipByChampionshipId) {
        this.championshipByChampionshipId = championshipByChampionshipId;
    }
}
