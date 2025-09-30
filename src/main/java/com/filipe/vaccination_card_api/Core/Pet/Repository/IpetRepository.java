package com.filipe.vaccination_card_api.Core.Pet.Repository;

import java.util.List;

import com.filipe.vaccination_card_api.Core.Pet.Pet;

public interface IpetRepository {
    Pet createPet(Pet pet);
    List<Pet> getAllPets();
    Pet getPetById(int id);
    List<Pet> getAllActivePets();
    Pet updateActive(boolean active, int id);
    Pet updatePet(Pet pet);
    Boolean deletePet(int id);
}