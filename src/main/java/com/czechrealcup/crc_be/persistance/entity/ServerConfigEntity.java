package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "server_config", schema = "crc_db", catalog = "")
public class ServerConfigEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "server_config_id", nullable = false)
    private long serverConfigId;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "URL", nullable = true, length = 255)
    private String url;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "config_type_id", referencedColumnName = "config_type_id")
    private ConfigTypeEntity configTypeByConfigTypeId;
    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
    private RaceEntity raceByRaceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerConfigEntity that = (ServerConfigEntity) o;
        return serverConfigId == that.serverConfigId && Objects.equals(name, that.name) && Objects.equals(url, that.url) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverConfigId, name, url, deletedAt, updatedAt, createdAt);
    }

    public ConfigTypeEntity getConfigTypeByConfigTypeId() {
        return configTypeByConfigTypeId;
    }

    public void setConfigTypeByConfigTypeId(ConfigTypeEntity configTypeByConfigTypeId) {
        this.configTypeByConfigTypeId = configTypeByConfigTypeId;
    }

    public RaceEntity getRaceByRaceId() {
        return raceByRaceId;
    }

    public void setRaceByRaceId(RaceEntity raceByRaceId) {
        this.raceByRaceId = raceByRaceId;
    }
}
