package com.filipe.vaccination_card_api.Core.Pet.Services;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.Repository.IpetRepository;
import com.filipe.vaccination_card_api.Core.Pet.UseCases.GetPetUseCase;

public class GetPetService implements GetPetUseCase{
    private final IpetRepository petRepository;

    public GetPetService(IpetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet execute(int id) {
        Pet pet = this.petRepository.getPetById(id);

        return  pet;
    }
}
