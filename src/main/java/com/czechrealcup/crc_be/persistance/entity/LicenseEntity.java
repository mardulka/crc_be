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
@Table(name = "license", schema = "crc_db", catalog = "")
public class LicenseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "license_id", nullable = false)
    private long licenseId;
    @Basic
    @Column(name = "name", nullable = true, length = 64)
    private String name;
    @Basic
    @Column(name = "abbr", nullable = false, length = 16)
    private String abbr;
    @Basic
    @Column(name = "active", nullable = false)
    private byte active;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "licenseByLicenseId")
    private Collection<SimulatorLicenseEntity> simulatorLicensesByLicenseId;
    @OneToMany(mappedBy = "licenseByLicenseId")
    private Collection<UserLicenseEntity> userLicensesByLicenseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicenseEntity that = (LicenseEntity) o;
        return licenseId == that.licenseId && active == that.active && Objects.equals(name, that.name) && Objects.equals(abbr, that.abbr) && Objects.equals(description, that.description) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseId, name, abbr, active, description, deletedAt, createdAt, updatedAt);
    }

    public Collection<SimulatorLicenseEntity> getSimulatorLicensesByLicenseId() {
        return simulatorLicensesByLicenseId;
    }

    public void setSimulatorLicensesByLicenseId(Collection<SimulatorLicenseEntity> simulatorLicensesByLicenseId) {
        this.simulatorLicensesByLicenseId = simulatorLicensesByLicenseId;
    }

    public Collection<UserLicenseEntity> getUserLicensesByLicenseId() {
        return userLicensesByLicenseId;
    }

    public void setUserLicensesByLicenseId(Collection<UserLicenseEntity> userLicensesByLicenseId) {
        this.userLicensesByLicenseId = userLicensesByLicenseId;
    }
}
