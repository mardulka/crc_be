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
@Table(name = "car_category", schema = "crc_db")
public class CarCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "car_category_id", nullable = false)
    private long carCategoryId;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "abbr", nullable = false, length = 16)
    private String abbr;

    @Basic
    @Column(name = "logo_URL")
    private String logoUrl;

    @Basic
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "carCategory")
    private Collection<CarEntity> cars;

    @OneToMany(mappedBy = "carCategory")
    private Collection<RaceCategoryEntity> raceCategories;

    @OneToMany(mappedBy = "carCategory")
    private Collection<SimulatorCarCategoryEntity> simulatorCarCategories;

}
