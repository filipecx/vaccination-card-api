package com.filipe.vaccination_card_api.Core.Pet.Services;

import com.filipe.vaccination_card_api.Core.Pet.Repository.IpetRepository;
import com.filipe.vaccination_card_api.Core.Pet.UseCases.DeletePetUseCase;

public class DeletePetService implements DeletePetUseCase{
    private final IpetRepository ipetRepository;
    public DeletePetService(IpetRepository ipetRepository) {
        this.ipetRepository = ipetRepository;
    }

    public Boolean execute(int id) {
        ipetRepository.deletePet(id);
        return true;
    }

}
