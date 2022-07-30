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
@Table(name = "role", schema = "crc_db", catalog = "")
public class RoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private long roleId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "color_name", nullable = true, length = 255)
    private String colorName;
    @Basic
    @Column(name = "color", nullable = true, length = 255)
    private String color;
    @Basic
    @Column(name = "active", nullable = true)
    private Byte active;
    @Basic
    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "new_column", nullable = true)
    private Integer newColumn;
    @OneToMany(mappedBy = "roleByRoleId")
    private Collection<UserRoleEntity> userRolesByRoleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return roleId == that.roleId && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(colorName, that.colorName) && Objects.equals(color, that.color) && Objects.equals(active, that.active) && Objects.equals(deletedAt, that.deletedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(newColumn, that.newColumn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, name, description, colorName, color, active, deletedAt, createdAt, updatedAt, newColumn);
    }

    public Collection<UserRoleEntity> getUserRolesByRoleId() {
        return userRolesByRoleId;
    }

    public void setUserRolesByRoleId(Collection<UserRoleEntity> userRolesByRoleId) {
        this.userRolesByRoleId = userRolesByRoleId;
    }
}
