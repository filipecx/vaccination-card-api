package com.filipe.vaccination_card_api.Core.Vaccination.Services;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.Repository.IpetRepository;
import com.filipe.vaccination_card_api.Core.Vaccination.IvaccinationRepository;
import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Core.Vaccination.UseCases.CreateVaccinationUseCase;

public class CreateVaccinationService implements CreateVaccinationUseCase{
    private final IvaccinationRepository ivaccinationRepository;
    private final IpetRepository ipetRepository;

    public CreateVaccinationService(IvaccinationRepository ivaccinationRepository, IpetRepository ipetRepository) {
        this.ivaccinationRepository = ivaccinationRepository;
        this.ipetRepository = ipetRepository;
    }

    @Override
    public Vaccination execute(Vaccination vaccination) {
        Pet pet = this.ipetRepository.getPetById(vaccination.getPet().getId());

        Vaccination newVaccination = new Vaccination(
            vaccination.getDate(), 
            vaccination.getNextAdministration(), 
            false, 
            vaccination.getVaccineName(), 
            vaccination.getVaccineManufacturer(), 
            vaccination.getVaccineBatchNumber(), 
            vaccination.getVeterinarianName(), 
            vaccination.getVeterinarianCrmv(), 
            pet);

        Vaccination persistedVaccination = ivaccinationRepository.createVaccination(newVaccination);
        return persistedVaccination;
    }
}
