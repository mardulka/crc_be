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
@Table(name = "application", schema = "crc_db", catalog = "")
public class ApplicationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "application_id", nullable = false)
    private long applicationId;

    @Basic
    @Column(name = "res_position", nullable = true)
    private Integer resPosition;

    @Basic
    @Column(name = "res_points", nullable = true)
    private Integer resPoints;

    @Basic
    @Column(name = "res_class_position", nullable = true)
    private Integer resClassPosition;

    @Basic
    @Column(name = "res_class_points", nullable = true)
    private Integer resClassPoints;

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
    @JoinColumn(name = "participation_id", referencedColumnName = "participation_id", nullable = false)
    private ParticipationEntity participation;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private CarClassEntity carClass;

    @ManyToOne
    @JoinColumn(name = "livery_id", referencedColumnName = "livery_id", nullable = false)
    private LiveryEntity livery;

}

