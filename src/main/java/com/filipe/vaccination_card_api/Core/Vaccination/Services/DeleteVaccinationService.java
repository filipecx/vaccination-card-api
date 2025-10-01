package com.filipe.vaccination_card_api.Core.Vaccination.Services;

import org.springframework.stereotype.Service;

import com.filipe.vaccination_card_api.Core.Vaccination.IvaccinationRepository;
import com.filipe.vaccination_card_api.Core.Vaccination.UseCases.DeleteVaccinationUseCase;

@Service
public class DeleteVaccinationService implements DeleteVaccinationUseCase{
    private final IvaccinationRepository ivaccinationRepository;

    public DeleteVaccinationService(IvaccinationRepository ivaccinationRepository) {
        this.ivaccinationRepository = ivaccinationRepository;
    }

    public Boolean execute(int id) {
        ivaccinationRepository.deleteVaccination(id);
        return true;
    }

}
