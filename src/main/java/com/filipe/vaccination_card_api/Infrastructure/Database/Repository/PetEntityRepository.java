package com.filipe.vaccination_card_api.Infrastructure.Database.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filipe.vaccination_card_api.Infrastructure.Database.Entity.PetEntity;

public interface PetEntityRepository extends JpaRepository<PetEntity, Integer>{
    List<PetEntity> findAllByActiveTrue();
}
