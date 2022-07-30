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
@Table(name = "team", schema = "crc_db", catalog = "")
public class TeamEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "team_id", nullable = false)
    private long teamId;
    @Basic
    @Column(name = "name", nullable = false, length = 64)
    private String name;
    @Basic
    @Column(name = "abbr", nullable = false, length = 3)
    private String abbr;
    @Basic
    @Column(name = "logo_URL", nullable = true, length = 255)
    private String logoUrl;
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
    @OneToMany(mappedBy = "teamByTeamId")
    private Collection<MembershipEntity> membershipsByTeamId;
    @OneToMany(mappedBy = "teamByTeamId")
    private Collection<TeamParticipationEntity> teamParticipationsByTeamId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamEntity that = (TeamEntity) o;
        return teamId == that.teamId && active == that.active && Objects.equals(name, that.name) && Objects.equals(abbr, that.abbr) && Objects.equals(logoUrl, that.logoUrl) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, name, abbr, logoUrl, active, deletedAt, createdAt, updatedAt);
    }

    public Collection<MembershipEntity> getMembershipsByTeamId() {
        return membershipsByTeamId;
    }

    public void setMembershipsByTeamId(Collection<MembershipEntity> membershipsByTeamId) {
        this.membershipsByTeamId = membershipsByTeamId;
    }

    public Collection<TeamParticipationEntity> getTeamParticipationsByTeamId() {
        return teamParticipationsByTeamId;
    }

    public void setTeamParticipationsByTeamId(Collection<TeamParticipationEntity> teamParticipationsByTeamId) {
        this.teamParticipationsByTeamId = teamParticipationsByTeamId;
    }
}
