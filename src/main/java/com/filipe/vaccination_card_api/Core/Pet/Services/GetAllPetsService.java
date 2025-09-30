package com.filipe.vaccination_card_api.Core.Pet.Services;

import java.util.List;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.Repository.IpetRepository;
import com.filipe.vaccination_card_api.Core.Pet.UseCases.GetAllPetsUseCase;

public class GetAllPetsService implements GetAllPetsUseCase{
    private IpetRepository petRepository;

    public GetAllPetsService(IpetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> execute() {
        List<Pet> listOfPets = petRepository.getAllPets();
        return listOfPets;
    }
   

}
