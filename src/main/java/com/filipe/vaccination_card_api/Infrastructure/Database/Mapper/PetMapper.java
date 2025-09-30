package com.filipe.vaccination_card_api.Infrastructure.Database.Mapper;

import java.util.List;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Infrastructure.Database.DatabaseError.PetMapperError;
import com.filipe.vaccination_card_api.Infrastructure.Database.Entity.PetEntity;

public class PetMapper {
    public Pet toDomain(PetEntity petEntity) {
        if (petEntity == null) {
            throw new PetMapperError("No pet data on the database");
        }
        return new Pet(petEntity.getName(), petEntity.getImageUrl()); 
    }

    public List<Pet> toDomainList(List<PetEntity> petEntitiesList) {
        if (petEntitiesList == null) {
            throw new PetMapperError("No pet data on the database");
        }
        return petEntitiesList.stream().map(entity -> toDomain(entity)).toList();
    }

    public PetEntity toEntity(Pet pet) {
        if (pet == null) {
            throw new PetMapperError("No domain pet object");
        }
        PetEntity petEntity = new PetEntity();

        petEntity.setImageUrl(pet.getImageUrl());
        petEntity.setName(pet.getName());
        
        return petEntity;
    }
}
