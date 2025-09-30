package com.filipe.vaccination_card_api.Core.Pet.Services;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.DTO.PetRequestDTO;
import com.filipe.vaccination_card_api.Core.Pet.Repository.IpetRepository;
import com.filipe.vaccination_card_api.Core.Pet.UseCases.UpdatePetUseCase;

public class UpdatePetService implements UpdatePetUseCase{
    private IpetRepository petRepository;

    public UpdatePetService(IpetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet execute(PetRequestDTO petDTO, int id) {
        Pet petToUpdate = new Pet(petDTO.name(), petDTO.image_url());
        Pet updatedPet = this.petRepository.updatePet(petToUpdate);

        return updatedPet;
    }
}
