package com.czechrealcup.crc_be.persistance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "circuit", schema = "crc_db", catalog = "")
public class CircuitEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "circuit_id", nullable = false)
    private long circuitId;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Basic
    @Column(name = "fictional", nullable = false)
    private byte fictional;

    @Basic
    @Column(name = "logo_URL", nullable = true, length = 255)
    private String logoUrl;

    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private CountryEntity country;

    @OneToMany(mappedBy = "circuit")
    private Collection<CircuitLayoutEntity> circuitLayouts;
}
