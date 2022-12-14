package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "simulator_license", schema = "crc_db")
@IdClass(SimulatorLicenseEntityPK.class)
public class SimulatorLicenseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "simulator_id", nullable = false)
    private long simulatorId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "license_id", nullable = false)
    private long licenseId;

    @Basic
    @Column(name = "sim_license_id")
    private Integer simLicenseId;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "simulator_id", referencedColumnName = "simulator_id", nullable = false, insertable = false, updatable = false)
    private SimulatorEntity simulator;

    @ManyToOne
    @JoinColumn(name = "license_id", referencedColumnName = "license_id", nullable = false, insertable = false, updatable = false)
    private LicenseEntity license;
}
