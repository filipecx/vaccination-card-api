package com.filipe.vaccination_card_api.Core.Vaccination.UseCases;

import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Core.Vaccination.DTO.VaccinationRequestDTO;

public interface UpdateVaccination {
    Vaccination execute(VaccinationRequestDTO vaccinationRequestDTO);
}
