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
@Table(name = "cup_category", schema = "crc_db", catalog = "")
public class CupCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cup_category_id", nullable = false)
    private long cupCategoryId;

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;

    @Basic
    @Column(name = "abbr", nullable = true, length = 32)
    private String abbr;

    @Basic
    @Column(name = "active", nullable = true)
    private Byte active;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "cupCategory")
    private Collection<RaceCategoryEntity> raceCategories;

    @OneToMany(mappedBy = "cupCategory")
    private Collection<SimulatorCupCategoryEntity> simulatorCupCategories;

}
