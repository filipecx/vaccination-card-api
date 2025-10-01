package com.filipe.vaccination_card_api.Infrastructure.Database.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filipe.vaccination_card_api.Infrastructure.Database.Entity.VaccinationEntity;

public interface VaccinationEntityRepository extends JpaRepository<VaccinationEntity, Integer>{
    List<VaccinationEntity> findAllByPet_IdAndCompletedFalse(int id);
    List<VaccinationEntity> findAllByPet_IdAndCompletedFalseOrderByNextAdministrationDesc(int id);
}
