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
@Table(name = "license", schema = "crc_db")
public class LicenseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "license_id", nullable = false)
    private long licenseId;

    @Basic
    @Column(name = "name", length = 64)
    private String name;

    @Basic
    @Column(name = "abbr", nullable = false, length = 16)
    private String abbr;

    @Basic
    @Column(name = "active", nullable = false)
    private byte active;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "license")
    private Collection<SimulatorLicenseEntity> simulatorLicenses;

    @OneToMany(mappedBy = "license")
    private Collection<UserLicenseEntity> userLicenses;
}
