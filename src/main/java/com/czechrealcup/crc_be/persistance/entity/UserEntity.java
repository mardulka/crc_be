package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
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
    private CountryEntity country;

    @OneToMany(mappedBy = "user")
    private Collection<UserCrewEntity> userCrews;

    @OneToMany(mappedBy = "user")
    private Collection<UserLicenseEntity> userLicenses;

    @OneToMany(mappedBy = "user")
    private Collection<UserRoleEntity> userRoles;
}
