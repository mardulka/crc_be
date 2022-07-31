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
@Table(name = "race_category", schema = "crc_db", catalog = "")
public class RaceCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "race_category_id", nullable = false)
    private long raceCategoryId;

    @Basic
    @Column(name = "abbr", nullable = false, length = 255)
    private String abbr;

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Basic
    @Column(name = "overall", nullable = false)
    private byte overall;

    @Basic
    @Column(name = "active", nullable = false)
    private byte active;

    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "raceCategory")
    private Collection<CarClassEntity> carClasses;

    @ManyToOne
    @JoinColumn(name = "championship_id", referencedColumnName = "championship_id")
    private ChampionshipEntity championship;

    @ManyToOne
    @JoinColumn(name = "car_category_id", referencedColumnName = "car_category_id")
    private CarCategoryEntity carCategory;

    @ManyToOne
    @JoinColumn(name = "cup_category_id", referencedColumnName = "cup_category_id")
    private CupCategoryEntity cupCategory;
}
