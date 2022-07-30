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
@Table(name = "class", schema = "crc_db", catalog = "")
public class CarClassEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "class_id", nullable = false)
    private long classId;

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Basic
    @Column(name = "overall", nullable = false)
    private byte overall;

    @Basic
    @Column(name = "order", nullable = true)
    private Integer order;

    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "carClass")
    private Collection<ApplicationEntity> applications;

    @ManyToOne
    @JoinColumn(name = "set_id", referencedColumnName = "set_id")
    private SetEntity set; //TODO check many to many relation

    @ManyToOne
    @JoinColumn(name = "race_category_id", referencedColumnName = "race_category_id")
    private RaceCategoryEntity raceCategory;

}
