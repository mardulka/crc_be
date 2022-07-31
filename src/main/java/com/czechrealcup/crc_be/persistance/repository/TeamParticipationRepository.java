package com.czechrealcup.crc_be.persistance.repository;

import com.czechrealcup.crc_be.persistance.entity.TeamParticipationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamParticipationRepository extends JpaRepository<TeamParticipationEntity, Long> {

}
