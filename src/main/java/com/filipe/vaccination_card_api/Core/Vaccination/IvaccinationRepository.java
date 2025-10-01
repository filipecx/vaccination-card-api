package com.filipe.vaccination_card_api.Core.Vaccination;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IvaccinationRepository {
    Vaccination createVaccination(Vaccination vaccination);
    List<Vaccination> getAllVaccinations();
    List<Vaccination> getAllDoneVaccinationsByPetId(int id);
    List<Vaccination> getNextVacinationsByPetId(int id);
    Vaccination getVaccination(int id);
    Vaccination updateVaccination(Vaccination vaccination, int id);
    Boolean changeVaccinationDone(int id, boolean active);
    Boolean deleteVaccination(int id);
}
