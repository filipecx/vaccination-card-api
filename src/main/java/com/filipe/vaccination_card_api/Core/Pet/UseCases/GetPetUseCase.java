package com.filipe.vaccination_card_api.Core.Pet.UseCases;

import com.filipe.vaccination_card_api.Core.Pet.Pet;

public interface GetPetUseCase {
    Pet execute(int id);
}
