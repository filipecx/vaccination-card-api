package com.filipe.vaccination_card_api.Core.Pet.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.Repository.IpetRepository;
import com.filipe.vaccination_card_api.Core.Pet.UseCases.GetAllAcitvePets;

@Service
public class GetAllActivePetsService implements GetAllAcitvePets{

    private final IpetRepository ipetRepository;

    public GetAllActivePetsService(IpetRepository ipetRepository) {
        this.ipetRepository = ipetRepository;
    }

    public List<Pet> execute() {
        List<Pet> petList = ipetRepository.getAllActivePets();

        return petList;
    }

    

}
