package com.filipe.vaccination_card_api.Core.Vaccination.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.filipe.vaccination_card_api.Core.Vaccination.IvaccinationRepository;
import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Core.Vaccination.UseCases.GetAllVaccinationsUseCase;

@Service
public class GetAllVaccinationsService implements GetAllVaccinationsUseCase{
    private IvaccinationRepository ivaccinationRepository;

    public GetAllVaccinationsService (IvaccinationRepository ivaccinationRepository) {
        this.ivaccinationRepository = ivaccinationRepository;
    }

    public List<Vaccination> execute() {
        List<Vaccination> listOfVaccinations = ivaccinationRepository.getAllVaccinations();
        return listOfVaccinations;
    }
}
