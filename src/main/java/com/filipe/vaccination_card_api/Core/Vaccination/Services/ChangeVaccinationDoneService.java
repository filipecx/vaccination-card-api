package com.filipe.vaccination_card_api.Core.Vaccination.Services;

import org.springframework.stereotype.Service;

import com.filipe.vaccination_card_api.Core.Vaccination.IvaccinationRepository;
import com.filipe.vaccination_card_api.Core.Vaccination.UseCases.ChangeVaccinationDoneUseCase;

@Service
public class ChangeVaccinationDoneService implements ChangeVaccinationDoneUseCase{
    private final IvaccinationRepository ivaccinationRepository;

    public ChangeVaccinationDoneService(IvaccinationRepository ivaccinationRepository) {
        this.ivaccinationRepository = ivaccinationRepository;
    }

    public Boolean execute(int id, Boolean active) {
        ivaccinationRepository.changeVaccinationDone(id, active);

        return true;
    }

}
