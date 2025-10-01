package com.filipe.vaccination_card_api.Core.Vaccination.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.filipe.vaccination_card_api.Core.Vaccination.IvaccinationRepository;
import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Core.Vaccination.UseCases.GetNextVaccinationsUseCase;

@Service
public class GetNextVaccinationsService implements GetNextVaccinationsUseCase{
    private final IvaccinationRepository ivaccinationRepository;

    public GetNextVaccinationsService(IvaccinationRepository ivaccinationRepository) {
        this.ivaccinationRepository = ivaccinationRepository;
    }

    public List<Vaccination> execute(int id) {
        List<Vaccination> listOfVaccinations = ivaccinationRepository.getNextVacinationsByPetId(id);

        return listOfVaccinations;
    }
}
