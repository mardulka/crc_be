package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "user", schema = "crc_db", catalog = "")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 32)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;
    @Basic
    @Column(name = "nick_name", nullable = true, length = 32)
    private String nickName;
    @Basic
    @Column(name = "short_name", nullable = true, length = 3)
    private String shortName;
    @Basic
    @Column(name = "sex", nullable = true, length = 255)
    private String sex;
    @Basic
    @Column(name = "birth_date", nullable = true)
    private Date birthDate;
    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;
    @Basic
    @Column(name = "email_verified_at", nullable = true)
    private Timestamp emailVerifiedAt;
    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;
    @Basic
    @Column(name = "remember_token", nullable = true, length = 100)
    private String rememberToken;
    @Basic
    @Column(name = "steam_id", nullable = true)
    private Long steamId;
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
    @OneToMany(mappedBy = "userByOwnerId")
    private Collection<LiveryEntity> liveriesByUserId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<MembershipEntity> membershipsByUserId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<OrganizingEntity> organizingsByUserId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<ParticipationEntity> participationsByUserId;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private CountryEntity countryByCountryId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<UserCrewEntity> userCrewsByUserId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<UserLicenseEntity> userLicensesByUserId;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<UserRoleEntity> userRolesByUserId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId && active == that.active && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(nickName, that.nickName) && Objects.equals(shortName, that.shortName) && Objects.equals(sex, that.sex) && Objects.equals(birthDate, that.birthDate) && Objects.equals(email, that.email) && Objects.equals(emailVerifiedAt, that.emailVerifiedAt) && Objects.equals(password, that.password) && Objects.equals(rememberToken, that.rememberToken) && Objects.equals(steamId, that.steamId) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, nickName, shortName, sex, birthDate, email, emailVerifiedAt, password, rememberToken, steamId, active, deletedAt, createdAt, updatedAt);
    }

    public Collection<LiveryEntity> getLiveriesByUserId() {
        return liveriesByUserId;
    }

    public void setLiveriesByUserId(Collection<LiveryEntity> liveriesByUserId) {
        this.liveriesByUserId = liveriesByUserId;
    }

    public Collection<MembershipEntity> getMembershipsByUserId() {
        return membershipsByUserId;
    }

    public void setMembershipsByUserId(Collection<MembershipEntity> membershipsByUserId) {
        this.membershipsByUserId = membershipsByUserId;
    }

    public Collection<OrganizingEntity> getOrganizingsByUserId() {
        return organizingsByUserId;
    }

    public void setOrganizingsByUserId(Collection<OrganizingEntity> organizingsByUserId) {
        this.organizingsByUserId = organizingsByUserId;
    }

    public Collection<ParticipationEntity> getParticipationsByUserId() {
        return participationsByUserId;
    }

    public void setParticipationsByUserId(Collection<ParticipationEntity> participationsByUserId) {
        this.participationsByUserId = participationsByUserId;
    }

    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    public Collection<UserCrewEntity> getUserCrewsByUserId() {
        return userCrewsByUserId;
    }

    public void setUserCrewsByUserId(Collection<UserCrewEntity> userCrewsByUserId) {
        this.userCrewsByUserId = userCrewsByUserId;
    }

    public Collection<UserLicenseEntity> getUserLicensesByUserId() {
        return userLicensesByUserId;
    }

    public void setUserLicensesByUserId(Collection<UserLicenseEntity> userLicensesByUserId) {
        this.userLicensesByUserId = userLicensesByUserId;
    }

    public Collection<UserRoleEntity> getUserRolesByUserId() {
        return userRolesByUserId;
    }

    public void setUserRolesByUserId(Collection<UserRoleEntity> userRolesByUserId) {
        this.userRolesByUserId = userRolesByUserId;
    }
}
