package com.filipe.vaccination_card_api.Core.Pet.UseCases;

import java.util.List;

import com.filipe.vaccination_card_api.Core.Pet.Pet;

public interface GetAllPetsUseCase {
    List<Pet> execute();
}
