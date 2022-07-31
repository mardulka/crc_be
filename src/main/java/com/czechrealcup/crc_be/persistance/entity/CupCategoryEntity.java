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
@Table(name = "cup_category", schema = "crc_db")
public class CupCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cup_category_id", nullable = false)
    private long cupCategoryId;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "abbr", length = 32)
    private String abbr;

    @Basic
    @Column(name = "active")
    private Byte active;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "cupCategory")
    private Collection<RaceCategoryEntity> raceCategories;

    @OneToMany(mappedBy = "cupCategory")
    private Collection<SimulatorCupCategoryEntity> simulatorCupCategories;
}
