package com.filipe.vaccination_card_api.Core.Vaccination.UseCases;

import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;

public interface GetVaccination {
    Vaccination execute(int id);
}
