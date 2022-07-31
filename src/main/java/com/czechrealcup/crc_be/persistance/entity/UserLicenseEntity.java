package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "user_license", schema = "crc_db", catalog = "")
public class UserLicenseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_license_id", nullable = false)
    private long userLicenseId;

    @Basic
    @Column(name = "from", nullable = false)
    private Date from;

    @Basic
    @Column(name = "until", nullable = true)
    private Date until;

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
    @JoinColumn(name = "license_id", referencedColumnName = "license_id", nullable = false)
    private LicenseEntity licenseByLicenseId;
}
