package com.filipe.vaccination_card_api.Core.Pet.Services;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.Repository.IpetRepository;
import com.filipe.vaccination_card_api.Core.Pet.UseCases.ChangePetActiveUseCase;

public class ChangePetActiveService implements ChangePetActiveUseCase{
    private final IpetRepository ipetRepository;

    public ChangePetActiveService(IpetRepository ipetRepository) {
        this.ipetRepository = ipetRepository;
    }

    public Pet execute(Boolean active, int id) {
        Pet pet = ipetRepository.updateActive(active, id);
        return pet;
    }
}
