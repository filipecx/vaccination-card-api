package com.filipe.vaccination_card_api.Core.Vaccination.Services;

import com.filipe.vaccination_card_api.Core.Vaccination.IvaccinationRepository;
import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Core.Vaccination.UseCases.UpdateVaccination;

public class UpdateVaccinationService implements UpdateVaccination{
    private final IvaccinationRepository ivaccinationRepository;

    public UpdateVaccinationService(IvaccinationRepository ivaccinationRepository) {
        this.ivaccinationRepository = ivaccinationRepository;
    }

    public Vaccination execute(Vaccination vaccination, int id) {

        Vaccination updatedVaccination = ivaccinationRepository.updateVaccination(vaccination, id);
        return updatedVaccination;
    }


}
