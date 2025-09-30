package com.filipe.vaccination_card_api.Core.Pet.UseCases;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.DTO.PetRequestDTO;

public interface UpdatePetUseCase {
    Pet execute(PetRequestDTO pet, int id);
}
