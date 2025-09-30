package com.filipe.vaccination_card_api.Core.Vaccination.Services;

import com.filipe.vaccination_card_api.Core.Vaccination.IvaccinationRepository;
import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Core.Vaccination.UseCases.GetVaccination;

public class GetVaccinationService implements GetVaccination{
    private final IvaccinationRepository ivaccinationRepository;

    public GetVaccinationService(IvaccinationRepository ivaccinationRepository) {
        this.ivaccinationRepository = ivaccinationRepository;
    }


    public Vaccination execute(int id) {
        Vaccination vaccination = ivaccinationRepository.getVaccination(id);
        return vaccination;
    }
}
