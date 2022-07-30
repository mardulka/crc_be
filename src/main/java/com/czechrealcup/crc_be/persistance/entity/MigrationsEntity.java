package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "migrations", schema = "crc_db", catalog = "")
public class MigrationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "migration", nullable = false, length = 255)
    private String migration;
    @Basic
    @Column(name = "batch", nullable = false)
    private int batch;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MigrationsEntity that = (MigrationsEntity) o;
        return id == that.id && batch == that.batch && Objects.equals(migration, that.migration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, migration, batch);
    }
}
