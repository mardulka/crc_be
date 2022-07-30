package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "organizing", schema = "crc_db", catalog = "")
@IdClass(OrganizingEntityPK.class)
public class OrganizingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "championship_id", nullable = false)
    private long championshipId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private long userId;
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
    @JoinColumn(name = "championship_id", referencedColumnName = "championship_id", nullable = false, insertable = false, updatable = false)
    private ChampionshipEntity championshipByChampionshipId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)

    private UserEntity userByUserId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizingEntity that = (OrganizingEntity) o;
        return championshipId == that.championshipId && userId == that.userId && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(championshipId, userId, deletedAt, createdAt, updatedAt);
    }

    public ChampionshipEntity getChampionshipByChampionshipId() {
        return championshipByChampionshipId;
    }

    public void setChampionshipByChampionshipId(ChampionshipEntity championshipByChampionshipId) {
        this.championshipByChampionshipId = championshipByChampionshipId;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
