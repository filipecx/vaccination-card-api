package com.filipe.vaccination_card_api.Core.Vaccination.UseCases;

import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;

public interface ChangeVaccinationDoneUseCase {
    Vaccination execute(int id);
}
