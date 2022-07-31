package com.czechrealcup.crc_be.persistance.repository;

import com.czechrealcup.crc_be.persistance.entity.PracticeResultPenalizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeResultPenalizationRepository extends JpaRepository<PracticeResultPenalizationEntity, Long> {

}
