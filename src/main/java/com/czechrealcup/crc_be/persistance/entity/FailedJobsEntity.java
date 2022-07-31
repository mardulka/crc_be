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
@Table(name = "failed_jobs", schema = "crc_db")
public class FailedJobsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Basic
    @Column(name = "connection", nullable = false, length = -1)
    private String connection;

    @Basic
    @Column(name = "queue", nullable = false, length = -1)
    private String queue;

    @Basic
    @Column(name = "payload", nullable = false, length = -1)
    private String payload;

    @Basic
    @Column(name = "exception", nullable = false, length = -1)
    private String exception;

    @Basic
    @Column(name = "failed_at", nullable = false)
    private Timestamp failedAt;
}
