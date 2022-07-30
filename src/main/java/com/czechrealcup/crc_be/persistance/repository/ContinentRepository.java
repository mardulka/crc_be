package com.czechrealcup.crc_be.persistance.repository;

import com.czechrealcup.crc_be.persistance.entity.ContinentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContinentRepository extends JpaRepository<ContinentEntity, Long> {

}
