package com.filipe.vaccination_card_api.Core.Pet.Services;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.DTO.PetRequestDTO;
import com.filipe.vaccination_card_api.Core.Pet.Repository.IpetRepository;
import com.filipe.vaccination_card_api.Core.Pet.UseCases.CreatePetUseCase;

public class CreatePetService implements CreatePetUseCase{
    private final IpetRepository petRepository;

    public CreatePetService(IpetRepository petRepository){
        this.petRepository = petRepository;
    }

    public Pet execute(PetRequestDTO pet) {
        Pet newPet = new Pet(pet.name(), pet.image_url());
        Pet persistedPet = this.petRepository.createPet(newPet);
        
        return persistedPet;
    }
}
