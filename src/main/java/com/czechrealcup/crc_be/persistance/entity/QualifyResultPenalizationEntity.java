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
@Table(name = "qualify_result_penalization", schema = "crc_db")
@IdClass(QualifyResultPenalizationEntityPK.class)
public class QualifyResultPenalizationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "qualify_result_id", nullable = false)
    private long qualifyResultId;

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
    @JoinColumn(name = "qualify_result_id", referencedColumnName = "qualify_result_id", nullable = false, insertable = false, updatable = false)
    private QualifyResultEntity qualifyResult;

    @ManyToOne
    @JoinColumn(name = "penalization_id", referencedColumnName = "penalization_id", nullable = false, insertable = false, updatable = false)
    private PenalizationEntity penalization;
}
