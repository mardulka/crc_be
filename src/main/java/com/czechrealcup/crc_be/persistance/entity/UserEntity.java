package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "user", schema = "crc_db")
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
    @Column(name = "nick_name", length = 32)
    private String nickName;

    @Basic
    @Column(name = "short_name", length = 3)
    private String shortName;

    @Basic
    @Column(name = "sex")
    private String sex;

    @Basic
    @Column(name = "birth_date")
    private Date birthDate;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "email_verified_at")
    private Timestamp emailVerifiedAt;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "remember_token", length = 100)
    private String rememberToken;

    @Basic
    @Column(name = "steam_id")
    private Long steamId;

    @Basic
    @Column(name = "active", nullable = false)
    private byte active;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "owner")
    private Collection<LiveryEntity> liveries;

    @OneToMany(mappedBy = "user")
    private Collection<MembershipEntity> memberships;

    @OneToMany(mappedBy = "user")
    private Collection<OrganizingEntity> organizings;

    @OneToMany(mappedBy = "user")
    private Collection<ParticipationEntity> participations;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private CountryEntity country;

    @OneToMany(mappedBy = "user")
    private Collection<UserCrewEntity> userCrews;

    @OneToMany(mappedBy = "user")
    private Collection<UserLicenseEntity> userLicenses;

    @OneToMany(mappedBy = "user")
    private Collection<UserRoleEntity> userRoles;
}
