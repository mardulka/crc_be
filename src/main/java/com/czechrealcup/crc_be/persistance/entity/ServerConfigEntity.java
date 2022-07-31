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
@Table(name = "server_config", schema = "crc_db")
public class ServerConfigEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "server_config_id", nullable = false)
    private long serverConfigId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "URL")
    private String url;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "config_type_id", referencedColumnName = "config_type_id")
    private ConfigTypeEntity configType;

    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
    private RaceEntity race;
}
