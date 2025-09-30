package com.filipe.vaccination_card_api.Core.Vaccination.DTO;

import java.time.LocalDate;

import com.filipe.vaccination_card_api.Core.Pet.Pet;

public record VaccinationRequestDTO(
    LocalDate date,
    LocalDate nextAdministration,
    boolean completed,
    String vaccineName,
    String vaccineManufacturer,
    String vaccineBatchNumber,
    String veterinarianName,
    String veterinarianCrmv,
    Pet pet

) {

    
}
