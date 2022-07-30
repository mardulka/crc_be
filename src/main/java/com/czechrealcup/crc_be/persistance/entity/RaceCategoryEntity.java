package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
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
    private Collection<CarClassEntity> carClassesByRaceCategoryId;
    @ManyToOne
    @JoinColumn(name = "championship_id", referencedColumnName = "championship_id")
    private ChampionshipEntity championshipByChampionshipId;
    @ManyToOne
    @JoinColumn(name = "car_category_id", referencedColumnName = "car_category_id")
    private CarCategoryEntity carCategoryByCarCategoryId;
    @ManyToOne
    @JoinColumn(name = "cup_category_id", referencedColumnName = "cup_category_id")
    private CupCategoryEntity cupCategoryByCupCategoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceCategoryEntity that = (RaceCategoryEntity) o;
        return raceCategoryId == that.raceCategoryId && overall == that.overall && active == that.active && Objects.equals(abbr, that.abbr) && Objects.equals(description, that.description) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceCategoryId, abbr, description, overall, active, deletedAt, createdAt, updatedAt);
    }

    public Collection<CarClassEntity> getCarClassesByRaceCategoryId() {
        return carClassesByRaceCategoryId;
    }

    public void setCarClassesByRaceCategoryId(Collection<CarClassEntity> clazzesByRaceCategoryId) {
        this.carClassesByRaceCategoryId = clazzesByRaceCategoryId;
    }

    public ChampionshipEntity getChampionshipByChampionshipId() {
        return championshipByChampionshipId;
    }

    public void setChampionshipByChampionshipId(ChampionshipEntity championshipByChampionshipId) {
        this.championshipByChampionshipId = championshipByChampionshipId;
    }

    public CarCategoryEntity getCarCategoryByCarCategoryId() {
        return carCategoryByCarCategoryId;
    }

    public void setCarCategoryByCarCategoryId(CarCategoryEntity carCategoryByCarCategoryId) {
        this.carCategoryByCarCategoryId = carCategoryByCarCategoryId;
    }

    public CupCategoryEntity getCupCategoryByCupCategoryId() {
        return cupCategoryByCupCategoryId;
    }

    public void setCupCategoryByCupCategoryId(CupCategoryEntity cupCategoryByCupCategoryId) {
        this.cupCategoryByCupCategoryId = cupCategoryByCupCategoryId;
    }
}
