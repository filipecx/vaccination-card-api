package com.filipe.vaccination_card_api.Core.Vaccination.Services;

import java.util.List;

import com.filipe.vaccination_card_api.Core.Vaccination.IvaccinationRepository;
import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Core.Vaccination.UseCases.GetAllDoneVaccinationsUseCase;

public class GetAllDoneVaccinationsService implements GetAllDoneVaccinationsUseCase{
    private final IvaccinationRepository ivaccinationRepository;

    public GetAllDoneVaccinationsService (IvaccinationRepository ivaccinationRepository) {
        this.ivaccinationRepository = ivaccinationRepository;
    }

    public List<Vaccination> execute(int id) {
        List<Vaccination> lVaccinations = ivaccinationRepository.getAllDoneVaccinationsByPetId(id);
        return lVaccinations;
    }

}
