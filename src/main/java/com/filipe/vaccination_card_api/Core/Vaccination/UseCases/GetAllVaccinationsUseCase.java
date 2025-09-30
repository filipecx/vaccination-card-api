package com.filipe.vaccination_card_api.Core.Vaccination.UseCases;

import java.util.List;

import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;

public interface GetAllVaccinationsUseCase {
    List<Vaccination> execute();}
