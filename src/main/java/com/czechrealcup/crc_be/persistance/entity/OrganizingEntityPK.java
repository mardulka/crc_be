package com.czechrealcup.crc_be.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
public class OrganizingEntityPK implements Serializable {
    @Column(name = "championship_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long championshipId;
    @Column(name = "user_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizingEntityPK that = (OrganizingEntityPK) o;
        return championshipId == that.championshipId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(championshipId, userId);
    }
}
