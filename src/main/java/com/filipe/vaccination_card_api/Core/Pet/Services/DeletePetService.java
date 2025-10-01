package com.filipe.vaccination_card_api.Core.Pet.Services;

import org.springframework.stereotype.Service;

import com.filipe.vaccination_card_api.Core.Pet.Repository.IpetRepository;
import com.filipe.vaccination_card_api.Core.Pet.UseCases.DeletePetUseCase;

@Service
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
