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
@Table(name = "livery", schema = "crc_db", catalog = "")
public class LiveryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "livery_id", nullable = false)
    private long liveryId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "number", nullable = true)
    private Integer number;
    @Basic
    @Column(name = "custom", nullable = false)
    private byte custom;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "livery")
    private Collection<ApplicationEntity> applicationsByLiveryId;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private UserEntity userByOwnerId;
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id", nullable = false)
    private CarEntity carByCarId;
    @ManyToOne
    @JoinColumn(name = "simulator_id", referencedColumnName = "simulator_id")
    private SimulatorEntity simulatorBySimulatorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiveryEntity that = (LiveryEntity) o;
        return liveryId == that.liveryId && custom == that.custom && Objects.equals(name, that.name) && Objects.equals(number, that.number) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liveryId, name, number, custom, deletedAt, createdAt, updatedAt);
    }

    public Collection<ApplicationEntity> getApplicationsByLiveryId() {
        return applicationsByLiveryId;
    }

    public void setApplicationsByLiveryId(Collection<ApplicationEntity> applicationsByLiveryId) {
        this.applicationsByLiveryId = applicationsByLiveryId;
    }

    public UserEntity getUserByOwnerId() {
        return userByOwnerId;
    }

    public void setUserByOwnerId(UserEntity userByOwnerId) {
        this.userByOwnerId = userByOwnerId;
    }

    public CarEntity getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(CarEntity carByCarId) {
        this.carByCarId = carByCarId;
    }

    public SimulatorEntity getSimulatorBySimulatorId() {
        return simulatorBySimulatorId;
    }

    public void setSimulatorBySimulatorId(SimulatorEntity simulatorBySimulatorId) {
        this.simulatorBySimulatorId = simulatorBySimulatorId;
    }
}
