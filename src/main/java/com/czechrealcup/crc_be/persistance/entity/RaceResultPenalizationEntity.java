package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "race_result_penalization", schema = "crc_db", catalog = "")
public class RaceResultPenalizationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "race_result_penalization_id", nullable = false)
    private long raceResultPenalizationId;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "race_result_id", referencedColumnName = "race_result_id", nullable = false)
    private RaceResultEntity raceResult;

    @ManyToOne
    @JoinColumn(name = "penalization_id", referencedColumnName = "penalization_id", nullable = false)
    private PenalizationEntity penalization;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "report_id")
    private ReportEntity report;
}
