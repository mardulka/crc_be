package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "user_crew", schema = "crc_db", catalog = "")
public class UserCrewEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_crew_id", nullable = false)
    private long userCrewId;
    @Basic
    @Column(name = "owner", nullable = false)
    private byte owner;
    @Basic
    @Column(name = "active", nullable = false)
    private byte active;
    @Basic
    @Column(name = "from", nullable = true)
    private Timestamp from;
    @Basic
    @Column(name = "until", nullable = true)
    private Timestamp until;
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
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "crew_id", referencedColumnName = "crew_id")
    private CrewEntity crewByCrewId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCrewEntity that = (UserCrewEntity) o;
        return userCrewId == that.userCrewId && owner == that.owner && active == that.active && Objects.equals(from, that.from) && Objects.equals(until, that.until) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userCrewId, owner, active, from, until, deletedAt, createdAt, updatedAt);
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public CrewEntity getCrewByCrewId() {
        return crewByCrewId;
    }

    public void setCrewByCrewId(CrewEntity crewByCrewId) {
        this.crewByCrewId = crewByCrewId;
    }
}
