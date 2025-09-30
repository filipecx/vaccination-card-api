package com.filipe.vaccination_card_api.Core.Vaccination.UseCases;

public interface ChangeVaccinationDoneUseCase {
    Boolean execute(int id, Boolean active);
}
