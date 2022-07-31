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
@Table(name = "car", schema = "crc_db")
public class CarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "car_id", nullable = false)
    private long carId;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "year", nullable = false)
    private Integer year;

    @Basic
    @Column(name = "active", nullable = false)
    private byte active;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "car_type_id", referencedColumnName = "car_type_id", nullable = false)
    private CarTypeEntity carType;

    @ManyToOne
    @JoinColumn(name = "car_category_id", referencedColumnName = "car_category_id", nullable = false)
    private CarCategoryEntity carCategory;

    @OneToMany(mappedBy = "car")
    private Collection<LiveryEntity> liveries;

    @OneToMany(mappedBy = "car")
    private Collection<SimulatorCarEntity> simulatorCars;

}
