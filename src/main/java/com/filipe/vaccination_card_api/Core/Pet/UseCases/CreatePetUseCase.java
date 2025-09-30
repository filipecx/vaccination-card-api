package com.filipe.vaccination_card_api.Core.Pet.UseCases;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.DTO.PetRequestDTO;

public interface CreatePetUseCase {
    Pet execute(PetRequestDTO pet);
}
