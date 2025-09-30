package com.filipe.vaccination_card_api.Infrastructure.Database.Repository;

import java.util.List;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.Repository.IpetRepository;
import com.filipe.vaccination_card_api.Infrastructure.Database.DatabaseError.PetEntityException;
import com.filipe.vaccination_card_api.Infrastructure.Database.Entity.PetEntity;
import com.filipe.vaccination_card_api.Infrastructure.Database.Mapper.PetMapper;

public class PetRepositoryImp implements IpetRepository{
    private final PetEntityRepository petEntityRepository;
    private final PetMapper petMapper;

    public PetRepositoryImp(PetEntityRepository petEntityRepository, PetMapper petMapper) {
        this.petEntityRepository = petEntityRepository;
        this.petMapper = petMapper;
    }

    @Override
    public Pet createPet(Pet pet) {
        PetEntity petEntity = petMapper.toEntity(pet);
        PetEntity savedPet = petEntityRepository.save(petEntity);
        return petMapper.toDomain(savedPet);
    }

    @Override
    public List<Pet> getAllPets() {
        List<PetEntity> listOfPetEntities = petEntityRepository.findAll();
        List<Pet> listOfPets = petMapper.toDomainList(listOfPetEntities);
        return listOfPets;
    }

    @Override
    public Pet getPetById(int id) {
        PetEntity petEntity = petEntityRepository.findById(id)
        .orElseThrow(() -> new PetEntityException("No pet found by this id"));

        Pet pet = petMapper.toDomain(petEntity);
        return pet;
    }

    @Override
    public List<Pet> getAllActivePets() {
        List<PetEntity> activePetsEntities = petEntityRepository.findAllByActiveTrue();
        List<Pet> activePets = petMapper.toDomainList(activePetsEntities);

        return activePets;
    }

    @Override
    public Pet updateActive(boolean active, int id) {
        PetEntity petEntity = petEntityRepository.findById(id)
        .orElseThrow(() -> new PetEntityException("Pet not found by this id"));
        petEntity.setActive(active);

        Pet pet = petMapper.toDomain(petEntity);
        return pet;
    }

    @Override
    public Pet updatePet(Pet pet) {
        PetEntity petEntity = petMapper.toEntity(pet);
        PetEntity savedPet = petEntityRepository.save(petEntity);
        return petMapper.toDomain(savedPet);
    }

    @Override
    public Boolean deletePet(int id) {
        petEntityRepository.deleteById(id);
        return true;
    }
}
