package com.czechrealcup.crc_be.persistance.repository;

import com.czechrealcup.crc_be.persistance.entity.QualifyResultPenalizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualifyResultPenalizationRepository extends JpaRepository<QualifyResultPenalizationEntity, Long> {

}
