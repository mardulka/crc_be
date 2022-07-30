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
    private Collection<CarTypeEntity> carTypesByManufacturerId;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private CountryEntity countryByCountryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturerEntity that = (ManufacturerEntity) o;
        return manufacturerId == that.manufacturerId && Objects.equals(name, that.name) && Objects.equals(abbr, that.abbr) && Objects.equals(logoUrl, that.logoUrl) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerId, name, abbr, logoUrl, deletedAt, createdAt, updatedAt);
    }

    public Collection<CarTypeEntity> getCarTypesByManufacturerId() {
        return carTypesByManufacturerId;
    }

    public void setCarTypesByManufacturerId(Collection<CarTypeEntity> carTypesByManufacturerId) {
        this.carTypesByManufacturerId = carTypesByManufacturerId;
    }

    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }
}
