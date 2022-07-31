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
@Table(name = "practice_result_penalization", schema = "crc_db")
@IdClass(PracticeResultPenalizationEntityPK.class)
public class PracticeResultPenalizationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "practice_result_id", nullable = false)
    private long practiceResultId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "penalization_id", nullable = false)
    private long penalizationId;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "practice_result_id", referencedColumnName = "practice_result_id", nullable = false, insertable = false, updatable = false)
    private PracticeResultEntity practiceResult;

    @ManyToOne
    @JoinColumn(name = "penalization_id", referencedColumnName = "penalization_id", nullable = false, insertable = false, updatable = false)
    private PenalizationEntity penalization;
}
