package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "manufacturer", schema = "crc_db", catalog = "")
public class ManufacturerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "manufacturer_id", nullable = false)
    private long manufacturerId;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Basic
    @Column(name = "abbr", nullable = false, length = 20)
    private String abbr;

    @Basic
    @Column(name = "logo_URL", nullable = true, length = 255)
    private String logoUrl;

    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "manufacturer")
    private Collection<CarTypeEntity> carTypes;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private CountryEntity country;
}
