package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLicenseEntity that = (UserLicenseEntity) o;
        return userLicenseId == that.userLicenseId && Objects.equals(from, that.from) && Objects.equals(until, that.until) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLicenseId, from, until, deletedAt, createdAt, updatedAt);
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public LicenseEntity getLicenseByLicenseId() {
        return licenseByLicenseId;
    }

    public void setLicenseByLicenseId(LicenseEntity licenseByLicenseId) {
        this.licenseByLicenseId = licenseByLicenseId;
    }
}
