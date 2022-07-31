package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "config_type", schema = "crc_db", catalog = "")
public class ConfigTypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "config_type_id", nullable = false)
    private long configTypeId;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @OneToMany(mappedBy = "configType")
    private Collection<ServerConfigEntity> serverConfigs;

}
