package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "membership", schema = "crc_db", catalog = "")
public class MembershipEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "membership_id", nullable = false)
    private long membershipId;
    @Basic
    @Column(name = "owner", nullable = false)
    private byte owner;
    @Basic
    @Column(name = "active", nullable = false)
    private byte active;
    @Basic
    @Column(name = "from", nullable = false)
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
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false)
    private TeamEntity teamByTeamId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembershipEntity that = (MembershipEntity) o;
        return membershipId == that.membershipId && owner == that.owner && active == that.active && Objects.equals(from, that.from) && Objects.equals(until, that.until) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membershipId, owner, active, from, until, deletedAt, createdAt, updatedAt);
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public TeamEntity getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(TeamEntity teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }
}
